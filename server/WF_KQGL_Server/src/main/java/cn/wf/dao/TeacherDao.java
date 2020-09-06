package cn.wf.dao;

import cn.wf.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeacherDao {

    //*-------------------将数据存入teacherfaqiandao，教师发布签到任务，向teacher发布签到任务的表中装入数据
    @Select("insert into teacherfaqiandao (qiandaoma,kechengmingcheng,suozaibanji," +
            " starttime,overtime,username,name,level,faqishijian)" +
            " values (#{qiandaoma},#{kechengmingcheng},#{suozaibanji},#{starttime}," +
            "#{overtime},#{username},#{name},#{level},#{faqishijian})")
    public void submitqiandao(@Param("qiandaoma")String qiandaoma,
                              @Param("kechengmingcheng")String kechengmingcheng,
                              @Param("suozaibanji")String suozaibanji,
                              @Param("starttime") String starttime ,
                              @Param("overtime") String overtime,
                              @Param("username")String username,
                              @Param("name")String name,
                              @Param("level")int level,
                              @Param("faqishijian")String faqishijian);



    //批量插入签到任务
//*-------------------null值studentqiandao------------------------------------------------------
    @Insert("insert into studentqiandao(username,name,qiandaozhuangtai,suozaibanji)" +
            "select                     username,name,qiandaozhuangtai,suozaibanji from user " +
            "where level=#{level} and suozaibanji=#{suozaibanji}")
    public void insertnullqiandaorenwu(@Param("level")int level,
                                       @Param("suozaibanji")String suozaibanji);

//--------------------------------------------------------

    //更新数据表studentqiandao中  班级为#{suozaibanji}，teacher为空 的记录 的faqishijian，设为前端发来的faqishijian
    //注意 判断teacher为空用的是  is  而不是=
    @Update("update studentqiandao set faqishijian=#{faqishijian} where" +
            " suozaibanji=#{suozaibanji} and teacher is null")
    public void updatefaqitime(@Param("faqishijian")String faqishijian,
                               @Param("suozaibanji")String suozaibanji);
            //    //是给一个确定的班级发布签到任务，所以表中已经有数据，仅需修改其中的签到状态数据即可
            //    //教师发布签到任务的同时，给strudenqiandao修改数据
            //    //0为未签到状态，1为已签到状态,超时后为3，不可再签到，签到仅需数分钟，同一名学生不可能存在同时有2个签到任务的
//*------------------补全studentqiandao
    @Update("update studentqiandao set qiandaozhuangtai = #{qiandaozhuangtai} ,kechengmingcheng=#{kechengmingcheng}," +
            "teacher = #{teacher}, overtime= #{overtime} ,starttime=#{starttime},qiandaoma=#{qiandaoma} " +
            "where faqishijian=#{faqishijian} and suozaibanji=#{suozaibanji}")
    public void updatestudentqiandao(
            @Param("qiandaozhuangtai")int qiandaozhuangtai,
            @Param("kechengmingcheng")String kechengmingcheng,
            @Param("teacher")String teacher,
            @Param("overtime")String overtime,
            @Param("starttime")String starttime,
            @Param("qiandaoma")String qiandaoma,
            @Param("faqishijian")String faqishijian,
            @Param("suozaibanji")String suozaibanji

            );

    //教师发布通知
    //*-------------------将数据存入tongzhi，教师发布通知
    @Select("insert into tongzhi (title,zhengwen,starttime,fabuzhe,fugaibanji) " +
            "values (#{title},#{zhengwen},#{starttime},#{fabuzhe},#{fugaibanji})")
    public void teacherfatongzhi(@Param("title")String title,
                                 @Param("zhengwen")String zhengwen,
                                 @Param("starttime")String starttime,
                                 @Param("fabuzhe") String fabuzhe ,
                                 @Param("fugaibanji") String fugaibanji  );

    //教师查自己发的通知
    @Select("select * from tongzhi where fabuzhe=#{fabuzhe}")
    public List<Tongzhi> teacherchazijifadetongzhi(@Param("fabuzhe")String fabuzhe);



    //超时处理前查询
    @Select("select * from studentqiandao")
    public StudentQiandao chaoshichuliqianchaxun();

    //签到超时处理
    @Update("update studentqiandao set qiandaozhuangtai = #{qiandaozhuangtai}" +
            "where qiandaozhuangtai = #{qiandaozhuangtai}")
    public StudentQiandao chaoshichuli( @Param("qiandaozhuangtai")String qiandaozhuangtai,
                                        @Param("qiandaozhuangtai")String qiandaozhuangtaichuli);

    //查询教师带的班级和课名
    @Select("select * from teachers where username =#{username}")
    public List<Teachers> teachersfindall(@Param("username")String username);

    //查询该教师名下的的学生，用于检查学生的签到状态
    //2个条件可以确定是某一名老师带的课，班级，课名
    @Select("select * from studentqiandao where" +
            " qiandaozhuangtai=#{qiandaozhuangtai}" +
            " and teacher = #{teacher}")
    public List<StudentQiandao> qiandaozhuangtai(
            @Param("qiandaozhuangtai")int qiandaozhuangtai,
            @Param("teacher")String teacher);





    //教师查看学生请假记录
    @Select("select * from qingjia where suozaibanji=#{suozaibanji}")
    public List<StudentQingjia> teacherchaxueshengqingjiajilu(@Param("suozaibanji")String suozaibanji);

    //教师查自己
    @Select("select suozaibanji from teachers where username=#{username}")
    public String teacherchaziji(String username);





}
