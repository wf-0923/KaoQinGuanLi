package cn.wf.service;

import cn.wf.pojo.StudentQiandao;
import cn.wf.pojo.StudentQingjia;
import cn.wf.pojo.Teachers;
import cn.wf.pojo.Tongzhi;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;
import java.util.List;

public interface TeacherService {
    //教师发签到任务
    public void submitqiandao(String qiandaoma,
                              String kechengmingcheng,
                              String suozaibanji,
                              String starttime,
                              String overtime,
                              String username,
                              String name,
                              int level,
                              String faqishijian);



    //批量插入新签到模板,后面仅需修改即可
    public void insertnullqiandaorenwu(int level,String suozaibanji  );

    public void updatefaqitime(String faqishijian,String suozaibanji);

//    教师发布签到任务的同时，给strudentqiandao修改数据
//    是给一个确定的班级发布签到任务，所以表中已经有数据，仅需修改其中的签到状态数据即可
//    //0为未签到状态，1为已签到状态,超时后为3，不可再签到，签到仅需数分钟，同一名学生不可能存在同时有2个签到任务的
public void updatestudentqiandao(
                                    int qiandaozhuangtai,
                                    String kechengmingcheng,
                                    String teacher,
                                    String overtime,
                                    String starttime,
                                    String qiandaoma,
                                    String faqishijian,
                                    String suozaibanji
                            );



    //查询学生的签到状态
    //2个条件可以确定是某一名老师带的课，班级，课名
    public List<StudentQiandao> qiandaozhuangtai(int qiandaozhuangtai,
                                              String teacher
                                              );

    //发布通知
    public void teacherfatongzhi(String title,
                              String zhengwen,
                              String starttime,
                               String fabuzhe ,
                               String fugaibanji  );

    //教师查自己发的通知
    public List<Tongzhi> teacherchazijifadetongzhi(String fabuzhe);

    //教师查看学生请假记录
    public List<StudentQingjia> teacherchaxueshengqingjiajilu(String suozaibanji);


    //教师查自己
    public String teacherchaziji(String username);

}
