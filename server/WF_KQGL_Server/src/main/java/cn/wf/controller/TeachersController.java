package cn.wf.controller;

import cn.wf.dao.MineDao;
import cn.wf.pojo.*;
import cn.wf.service.TeacherService;
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
public class TeachersController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private MineDao mineDao;



    //教师发布签到任务
    @RequestMapping("teacherfaqiandao")
    public String teacherfaqiandao(TeacherFaQiandao teacherFaQiandao, HttpSession session) {
        /*
        实现思路：
        1.判断发签到的人是否为教师，且签到属性中不能有空值
        2.发起签到的时候，自动保存一个系统时间，
        3.httpsession中保存了登录的用户的用户名，通过用户名调用GonggongUserShuxingDao，可以查到该用户的其他基本信息
        这些信息+前端发来的信息，整合存入表teacherfaqiandao中
        4.根据前端发来的属性：level，班级，课程，从user表中筛选匹配的学生，写入studentqiandao表中
            此时表中只有username,name,suozaibanji有值，其他都为null。
        5.要为表studentqiandao补全数据，依据是空状态的

         */
        //先看一下前台发来了什么东西
        System.out.println("表现层：看一下前台发来了什么东西" + teacherFaQiandao);

        //读取到用户名，登录时已经保存在session中了，只留了用户名，强转一下类型
        //注意，此时已经准备好了username了，下文就不用再准备了
        String username = (String) session.getAttribute("loginsuccess");

        //从前端返回的数据，默认不为空的
        //只有教师级别以上的人才有资格发布签到任务，学生为0，教师1，班主任2.辅导员3
        //用通用mysql查询办法↓↓↓↓↓↓↓↓↓↓↓↓，达到获取用户level的目的
        int level = mineDao.chaxunyidengluyonghujibenziliao(username).getLevel();
        if (level > 0) {
            System.out.println("表现层：用户 "+username+" 是教师，可以发布签到任务");
            if (teacherFaQiandao.getSuozaibanji().equals("") ||
                    teacherFaQiandao.getQiandaoma().equals("") ||
                    teacherFaQiandao.getStarttime().equals("") ||
                    teacherFaQiandao.getOvertime().equals("")) {
                System.out.println("表现层：新签到任务提交失败，申请内容为空");
                return "teachers/faqiandao/teacherfabuqiandaorenwufail";
            } else {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                String faqitime = df.format(new Date());// new Date()为获取当前系统时间
                System.out.println("表现层：教师" +username + "发起发布签到任务的申请");
                 /* 根据用户名查询该用户的基本信息
                 gonggongUserShuxingDao.chaxunyidengluyonghujibenziliao(username);
                 定义一些数据库属性，属性内容为上面查到的信息
                此name为teachername，表中存在学生的username，故取别名name */

                String name = mineDao.chaxunyidengluyonghujibenziliao(username).getName();
                String suozaibanji = mineDao.chaxunyidengluyonghujibenziliao(username).getSuozaibanji();
                String suozaixueyuan = mineDao.chaxunyidengluyonghujibenziliao(username).getSuozaixueyuan();
        //*-------------------将数据存入teacherfaqiandao
                System.out.println("表现层：正在将新签到任务的参数提交到数据库:" +
                        faqitime + "," + suozaibanji + "," + suozaixueyuan);
                teacherService.submitqiandao(teacherFaQiandao.getQiandaoma(),
                                                      teacherFaQiandao.getKechengmingcheng(),
                                                      teacherFaQiandao.getSuozaibanji(),
                                                      teacherFaQiandao.getStarttime(),
                                                      teacherFaQiandao.getOvertime(),
                                                      username,name,level,faqitime);


        //*-------------------null值studentqiandao，成批加入新签到任务,存在的数据存入studentqiandao
//                限定了level=0,就不会把教师加入到被签到成员中,附加班级，就不会加入全为空的空表
                teacherService.insertnullqiandaorenwu(0,teacherFaQiandao.getSuozaibanji());


                //*-------------------更新数据表studentqiandao中  班级为#{suozaibanji}，teacher为空 的记录 的faqishijian，
                // 设为前端发来的faqishijian，注意 判断teacher为空用的是  is  而不是=
                //此时的签到码为null，可以作为参数辅助查找
                teacherService.updatefaqitime(faqitime,teacherFaQiandao.getSuozaibanji());


                //*------------------补全studentqiandao，把签到任务参数写入新签到任务,把状态0写为0？把
                teacherService.updatestudentqiandao(0,teacherFaQiandao.getKechengmingcheng(),
                                                    username,teacherFaQiandao.getOvertime(),
                                                    teacherFaQiandao.getStarttime(),
                                                    teacherFaQiandao.getQiandaoma(),
                                                    faqitime,teacherFaQiandao.getSuozaibanji());
                System.out.println("表现层：新签到任务的参数已经提交到数据库");
                return "teachers/faqiandao/teacherfabuqiandaorenwusuccess";
            }
        }else {
            System.out.println("表现层：用户： "+session.getAttribute("loginsuccess")+"是学生，不能发布签到任务");
            return "teachers/faqiandao/teacherfabuqiandaorenwufail";
        }
    }



    //查询同学的签到状态
    //           System.out.println(kechengmingcheng+zuoyongbanji);
//            1为已经签到，0为未签到
    @RequestMapping("qiandaozhuangtai")
    public String qiandaozhuangtai(Model modelyiqiandao,HttpSession session){
       String username= (String) session.getAttribute("loginsuccess");
       //学生签到表里，教师的username是teacher
       String teacher = username;
       int level = mineDao.chaxunyidengluyonghujibenziliao(username).getLevel();
       if (level>0){
           System.out.println("表现层：是教师，查询其名下学生的签到状态");

           List<StudentQiandao> yiqiandao = teacherService.qiandaozhuangtai(1,teacher);
           modelyiqiandao.addAttribute("yiqiandao",yiqiandao);
           List<StudentQiandao> weiqiandao = teacherService.qiandaozhuangtai(0, teacher);
           modelyiqiandao.addAttribute("weiqiandao",weiqiandao);
           List<StudentQiandao> qiandaochaoshi = teacherService.qiandaozhuangtai(2, teacher);
           modelyiqiandao.addAttribute("qiandaochaoshi",qiandaochaoshi);
           System.out.println("表现层：签到状态查询成功");
           return "teachers/faqiandao/teacherfabuqiandaorenwusuccess";

       }else {
           System.out.println("表现层：不是教师");
           return "teachers/faqiandao/teacherfabuqiandaorenwusuccess";
       }

    }


    //教师发通知
    @RequestMapping("teacherfatongzhi")
    public String fatongzhi(Tongzhi tongzhi ,HttpSession session) {
        String username = (String) session.getAttribute("loginsuccess");
        int level = mineDao.chaxunyidengluyonghujibenziliao(username).getLevel();
        String name= mineDao.chaxunyidengluyonghujibenziliao(username).getName();
        if (level > 0) {
            System.out.println("表现层：用户 " + username + " 是教师，可以发布签到任务");
            if (    tongzhi.getTitle().equals("") ||
                    tongzhi.getZhengwen().equals("")||
                    tongzhi.getFugaibanji().equals("")){
                System.out.println("表现层：新通知发布失败，存在内容为空");
                return "teachers/fatongzhi/teacherfatongzhifail";
            } else {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                String faqitime = df.format(new Date());// new Date()为获取当前系统时间
                teacherService.teacherfatongzhi(tongzhi.getTitle(),
                                                tongzhi.getZhengwen(),
                                                faqitime,name,
                                                tongzhi.getFugaibanji());
                System.out.println("表现层：教师" + username + "发起发布签到任务的申请");
                return "teachers/fatongzhi/teacherfatongzhisuccess";
            }
        }else {
            System.out.println("表现测：不是教师，不能发通知/作业");
            return "teachers/fatongzhi/teacherfatongzhifail";
        }
    }

    //查教师自己发布的通知
    @RequestMapping("teacherchazijifadetongzhi")
    public String teacherchazijifadetongzhi(Model modeljiaoshichazijifadetongzhi,HttpSession session){
        //获得用户名，需要先强转类型为string
      String username= (String) session.getAttribute("loginsuccess");
      String name= mineDao.chaxunyidengluyonghujibenziliao(username).getName();
        //以自己的名字做参数查通知
         List<Tongzhi> list=  teacherService.teacherchazijifadetongzhi(name);
         modeljiaoshichazijifadetongzhi.addAttribute("modeljiaoshichazijifadetongzhi",list);
        System.out.println("业务层：查询了自己发布的通知");
        return "teachers/fatongzhi/teacherfatongzhisuccess";
    }

    //教师查看学生请假记录
    @RequestMapping("teacherchaxuesehngqingjiajilu")
    public String  teacherchaxuesehngqingjiajilu(Model modelchaxueshengqingjiajilu, HttpSession session){
        String username=(String)session.getAttribute("loginsuccess");
        String suozaibanji=teacherService.teacherchaziji(username);
        int level=mineDao.chaxunyidengluyonghujibenziliao(username).getLevel();
        System.out.println(suozaibanji);
        System.out.println("表现层：教师查学生请假记录");
        if (level>0){
            List<StudentQingjia> list= teacherService.teacherchaxueshengqingjiajilu(suozaibanji);
            modelchaxueshengqingjiajilu.addAttribute("chaxueshengqingjia",list);
            System.out.println(list);
            return "teachers/chaqingjia/chaqingjiasuccess";
        }else {
            return "teachers/chaqingjia/chaqingjiafail";
        }
    }


}
