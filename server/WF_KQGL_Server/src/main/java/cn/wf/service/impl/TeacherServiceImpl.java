package cn.wf.service.impl;

import cn.wf.dao.TeacherDao;
import cn.wf.pojo.StudentQiandao;
import cn.wf.pojo.StudentQingjia;
import cn.wf.pojo.Teachers;
import cn.wf.pojo.Tongzhi;
import cn.wf.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("teacherFaqiandaoService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    //教师发布签到任务，向teacher发布签到任务的表中装入数据
    public void submitqiandao(String qiandaoma, String kechengmingcheng, String suozaibanji,
                              String starttime, String overtime, String username, String name,
                              int level,String faqishijian) {
        System.out.println("业务层：正在把新签到数据写入数据库");
        teacherDao.submitqiandao(qiandaoma, kechengmingcheng, suozaibanji, starttime,
                                  overtime, username, name, level,faqishijian);
        System.out.println("业务层：新签到数据写入数据库成功");
    }


    //把学生基本的信息，空表单批量插入签到任务
    public void insertnullqiandaorenwu(int level,String suozaibanji ){

        teacherDao.insertnullqiandaorenwu(level,suozaibanji);
        System.out.println("业务层：已成批新建新签到任务");
    }
//    教师发布签到任务的同时，给strudentqiandao修改数据
//    是给一个确定的班级发布签到任务，所以表中已经有数据，仅需修改其中的签到状态数据即可
//    //0为未签到状态，1为已签到状态,超时后为2，不可再签到，签到仅需数分钟，同一名学生不可能存在同时有2个签到任务的
    public void updatestudentqiandao(   int qiandaozhuangtai,
                                        String kechengmingcheng,
                                        String teacher,
                                        String overtime,
                                        String starttime,
                                        String qiandaoma,
                                        String faqishijian,
                                        String suozaibanji
    ){
        System.out.println("业务层:更新签到任务空表");
        teacherDao.updatestudentqiandao( qiandaozhuangtai , kechengmingcheng,teacher ,
                overtime , starttime, qiandaoma,faqishijian,suozaibanji );
        System.out.println("业务层:更新签到任务空表成功");
    }





    public void updatefaqitime(String faqishijian,String suozaibanji){

        teacherDao.updatefaqitime(faqishijian,suozaibanji);
    }



    //超时处理前查询
    public StudentQiandao chaoshichuliqianchaxun(){
        System.out.println("业务层：超时处理前查询");
        return teacherDao.chaoshichuliqianchaxun();
    }

    //签到超时处理
    public StudentQiandao chaoshichuli(String qiandaozhuangtai,String qiandaozhuangtaichuli){
        System.out.println("业务层：超时处理");
        return teacherDao.chaoshichuli(qiandaozhuangtai,qiandaozhuangtaichuli);
    }



    public List<StudentQiandao> qiandaozhuangtai(int qiandaozhuangtai, String teacher) {
        System.out.println("业务层：查询了所有学生的签到状态");
        return teacherDao.qiandaozhuangtai(qiandaozhuangtai, teacher);
    }



    public List<Teachers> teachersfindall(String username) {
        System.out.println("业务层：根据用户名查询了教师带的所有班");
        return teacherDao.teachersfindall(username);
    }

   //教师发布通知
    public void teacherfatongzhi(String title, String zhengwen,
                                 String starttime, String fabuzhe,
                                 String fugaibanji) {
        teacherDao.teacherfatongzhi(title, zhengwen,
                                    starttime, fabuzhe, fugaibanji);
    }

    //教师查自己发的通知
    public List<Tongzhi> teacherchazijifadetongzhi(String fabuzhe){
        return teacherDao.teacherchazijifadetongzhi(fabuzhe);
    }

    //教师查看学生请假记录
    public List<StudentQingjia> teacherchaxueshengqingjiajilu(String suozaibanji){
        return teacherDao.teacherchaxueshengqingjiajilu(suozaibanji);
    }

    public String teacherchaziji(String username){
        return teacherDao.teacherchaziji(username);
    }

}
