package cn.wf.controller;


import cn.wf.dao.MineDao;
import cn.wf.pojo.TeacherFaQiandao;
import cn.wf.pojo.StudentQingjia;
import cn.wf.pojo.Tongzhi;
import cn.wf.pojo.User;
import cn.wf.service.MineService;
import cn.wf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping
public class StudentsController {


    @Autowired
    private StudentService studentService;

    @Autowired
    private MineService mineService;

    @Autowired
    private MineDao mineDao;
    //查课表


    //申请请假
    //        数据库时间类型timestamp，数据以string类型传到数据库时，自动转换为时间形式，
//        20200424.2112  -----→   2020-04-24 21：12
//        System.out.println(qingjia);

    //读取到用户名，登录时已经保存在session中了，只留了用户名，强转一下类型
    //注意，此时已经准备好了username了，下文就不用再准备了
    @RequestMapping("/shenqingqingjia")
    public String shenqingqingjia(StudentQingjia studentQingjia, HttpSession session) {
        String username = (String) session.getAttribute("loginsuccess");
        //只有学生需要申请请假，学生为0，教师1，班主任2.辅导员3
        //用通用mysql查询办法↓↓↓↓↓↓↓↓↓↓↓↓，达到获取用户level的目的
        int level = mineDao.chaxunyidengluyonghujibenziliao(username).getLevel();
        if (level == 0) {
            //从前端返回的数据，默认不为空的,需要取其属性的值，值为空才算是空
            if (studentQingjia.getQingjialeixing().equals("") ||
                    studentQingjia.getStarttime().equals("") ||
                    studentQingjia.getOvertime().equals("") ||
                    studentQingjia.getQingjialiyou().equals("")) {
                System.out.println("表现层：请假申请失败，申请内容为空");
                return "students/qingjia/shenqingqingjiafail";
            } else {
                System.out.println("表现层：有人发起请假申请");
                System.out.println("表现层：确认已经登录的用户名为： " + username);
                //根据用户名查询该用户的基本信息
//        gonggongUserShuxingDao.chaxunyidengluyonghujibenziliao(username);
//        定义一些数据库属性，属性内容为上面查到的信息
                String name = mineDao.chaxunyidengluyonghujibenziliao(username).getName();
                String suozaibanji = mineDao.chaxunyidengluyonghujibenziliao(username).getSuozaibanji();
                String suozaixueyuan = mineDao.chaxunyidengluyonghujibenziliao(username).getSuozaixueyuan();
                System.out.println("表现层：正在将请假参数提交到数据库:" + name + "," + suozaibanji + "," + suozaixueyuan);
                studentService.submitqingjia(username, name, suozaibanji, suozaixueyuan,
                        studentQingjia.getQingjialeixing(),
                        studentQingjia.getStarttime(), studentQingjia.getOvertime(),
                        studentQingjia.getQingjialiyou());
                System.out.println("表现层：请假申请的参数已经提交到数据库");
                return "students/qingjia/shenqingqingjiasuccess";

            }
        } else {
            System.out.println("表现层：用户" + username + "不是学生，无需申请请假");
            return "students/qingjia/shenqingqingjiafail";
        }


    }


    //查询请假信息
    @RequestMapping("/chakanwodeqingjiajilu")
    public String findAllqingjia(Model modelfindallqingjiajilu, HttpSession session) {
        String username = (String) session.getAttribute("loginsuccess");
        int level = mineDao.chaxunyidengluyonghujibenziliao(username).getLevel();
        if (level > 0) {
            System.out.println("表现层：用户" + username + "不是学生，故没有请假记录，");
            return "students/qingjia/shenqingqingjiafail";
        } else {
            System.out.println("表现层：查询所有信息");
            //调用service的方法
            //这里把登录的用户信息的用户名通过HttpSession 的getAttribute传给service的搜索所有用户的方法，因为类型不一样，所以强转一下
            List<StudentQingjia> list = studentService.sousuoqingjia((String) session.getAttribute("loginsuccess"));
            //重定向,先用sout检查一下list是否由数据
//        System.out.println("见擦汗一下list中有咩有"+list);

            modelfindallqingjiajilu.addAttribute("findallqingjiajilu", list);
            return "students/qingjia/shenqingqingjialist";
        }

    }


    //回应教师的签到任务
    @RequestMapping("xueshengqiandao")
    public String xueshengqiandao(TeacherFaQiandao teacherFaQiandao, HttpSession session) {
        String kechengmingcheng = teacherFaQiandao.getKechengmingcheng();
        String username = (String) session.getAttribute("loginsuccess");
        int level = mineDao.chaxunyidengluyonghujibenziliao(username).getLevel();
        if (teacherFaQiandao.getQiandaoma().equals("") ||
                teacherFaQiandao.getKechengmingcheng().equals("")) {
            System.out.println("表现层：存在空值，签到失败");
            return "students/qiandao/stuqiandaofail";
        } else {
            if (level < 1) {  //确认是否为学生
                //时间比较,系统时间
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//              System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
                String time = df.format(new Date());
                //相同类型比较，返回1则左边大，返回0相等，返回-1右边大
//              time.compareTo(overtime);
                //检查 签到码前
                int chageshu = studentService.chageshu(username, kechengmingcheng, 0);
                System.out.println(chageshu);
                if (chageshu > 0) { //确认存在需要签到的任务
                    //overtime
                    String overtime = studentService.qiandaoyanzheng(username, kechengmingcheng, 0).getOvertime();
                    if (time.compareTo(overtime) > 0) { //确认是否超时
                        System.out.println("表现层：签到超时，签到失败");
                        return "students/qiandao/stuqiandaofail";
                    } else {        //确认未超时
                        int qiandaozhuangtai = studentService.qiandaoyanzheng(username, kechengmingcheng, 0).getQiandaozhuangtai();
                        if (qiandaozhuangtai < 1) {
//                    qiandaozhuangtai<1 就说明该生还没有签到
                            String qiandaoma = studentService.qiandaoyanzheng(username, kechengmingcheng, 0).getQiandaoma();
                            //验证签到码，判断学生提交的签到码是否和教师发布的一致
                            if (qiandaoma.equals(teacherFaQiandao.getQiandaoma())) {
                                studentService.studentqiandao(1, 0, username, kechengmingcheng);
                                System.out.println("表现层：签到码正确，签到成功");
                                return "students/qiandao/stuqiandaosuccess";
                            } else {
                                System.out.println("表现层：签到码错误，请重新签到");
                                return "students/qiandao/stuqiandaofail";
                            }
                        } else {
                            System.out.println("表现层：该生已经签到过了，无需重复签到");
                            return "students/qiandao/stuqiandaoother";
                        }
                    }
                } else {
                    System.out.println("表现层：查到" + chageshu + "个关于这个学生的签到任务");
                    return "students/qiandao/stuqiandaoother";
                }
            } else {
                System.out.println("表现层：不是学生，无需签到");
                return "students/qiandao/stuqiandaofail";

            }
        }


    }

    //查通知
    @RequestMapping("studentchatongzhi")
    public String studentchatongzhi(Model modelstudentchatongzhi, HttpSession session) {
        //通过HttpSession查登录账号的用户名
        String username = (String) session.getAttribute("loginsuccess");
        //查用户名的USer表信息，拿到班级数据,顺便查以下level
        String suozaibanji = mineDao.chaxunyidengluyonghujibenziliao(username).getSuozaibanji();
        int level = mineDao.chaxunyidengluyonghujibenziliao(username).getLevel();
        if (level > 0) {
            System.out.println("用户是教师，跳转到教师看通知的页面");
            return "teachers/fatongzhi/teacherfatongzhisuccess";
        } else {
            System.out.println("用户是学生继续进行查通知");
            //把所在班级作为参数查通知输出为一个list
            List<Tongzhi> changguitongzhi = studentService.studentchatongzhi(suozaibanji);
            //把list中的数据传入model容器中，就像是个内存，可以保存
            modelstudentchatongzhi.addAttribute("modelstudentchatongzhi", changguitongzhi);
            //用return 跳转到chatongzhilist.jsp页
            return "students/chatongzhi/chatongzhilist";
        }
    }


    //查看我的
    @RequestMapping("mine")
    public String mine(Model modelmine, HttpSession session) {
        String username = (String) session.getAttribute("loginsuccess");
        System.out.println(username);
        List<User> list = mineService.mine(username);
        modelmine.addAttribute("mine", list);
        System.out.println("表现层：查看我的");
        return "mine/mine";
    }

}


//只要有人点了提交，就运行一次超时处理
          /*
        思路：
        1.表中一共有多少条，
        2.从第一条开始，如果系统时间大于overtime，则运行一次更新
         */
//        int counts= studentService.counts();
//        int hang;
//        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        String xitongtime = df1.format(new Date());// new Date()为获取当前系统时间
//        System.out.println("执行一次定时任务，系统时间为: "+xitongtime);
//        System.out.println("数据表学生签到中共有"+counts+"条记录");
//        for (hang=0;hang>counts;hang++){
//            System.out.println("----定时任务--------------------------------------------------------------");
//            System.out.println("执行一次定时任务，系统时间为: "+xitongtime);
//            //查询这一整行的数据
////           studentDao.limitmouhang(hang);
//            System.out.println("这条记录是："+studentService.limitmouhang(hang));
//            //如果这一行的签到状态不为0，该次签到任务已经签到过或者已经超时
//            if (studentService.limitmouhang(hang).getQiandaozhuangtai()!=0){
//                System.out.println("该次签到任务已经签到过或者已经超时，继续遍历");
//            }else {  //该生还没有签到或者没有超时
//                //判断该条签到任务是否超时，time.compareTo(overtime)>0,则系统时间大于overtime。所以超时了
//                if (xitongtime.compareTo(studentService.limitmouhang(hang).getOvertime())>0){
//                    //既然超时了，就改写签到状态未超时值2
//                    studentService.chaoshichuli(2);
//                    System.out.println("超时了，已经把签到码改为2");
//                }{
//                    System.out.println("没有超时，继续遍历");
//                }
//
//            }
//
//
//        }
