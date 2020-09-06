package cn.wf.dao;

import cn.wf.pojo.StudentQiandao;
import cn.wf.pojo.StudentQingjia;
import cn.wf.pojo.Tongzhi;
import cn.wf.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentDao {



    //保存一个请假
    @Select("insert into qingjia (username,name,suozaibanji,suozaixueyuan," +
            "qingjialeixing,starttime,overtime,qingjialiyou)" +
            " values (#{username},#{name},#{suozaibanji},#{suozaixueyuan}," +
            "#{qingjialeixing},#{starttime},#{overtime},#{qingjialiyou})")
    public void submitqingjia(@Param("username")String username,
                              @Param("name")String name,
                              @Param("suozaibanji")String suozaibanji ,
                              @Param("suozaixueyuan")String suozaixueyuan,
                              @Param("qingjialeixing")String qingjialeixing,
                              @Param("starttime") String starttime,
                              @Param("overtime")String overtime,
                              @Param("qingjialiyou")String qingjialiyou);

    //搜索请假
    @Select("select * from qingjia where username = #{username}")
    public List<StudentQingjia> sousuoqingjia(@Param("username")String username);


    //签到 改0为1
    @Select("update studentqiandao set qiandaozhuangtai=#{qiandaozhuangtai}" +
            " where qiandaozhuangtai=#{qiandaozhuangtai2} and " +
            "username = #{username} and kechengmingcheng=#{kechengmingcheng}")
    public StudentQiandao studentqiandao(@Param("qiandaozhuangtai")int qiandaozhuangtai,
                                         @Param("qiandaozhuangtai2")int qiandaozhuangtai2,
                                         @Param("username")String username,
                                         @Param("kechengmingcheng")String kechengmingcheng);

    //当签到状态为0的个数为0时，执行qiandaoyanzheng（）.getQiandaozhuangtai()会报空指针异常
    //那么我先查0个个数，如果不为0，那么再执行qiandaoyanzheng（）
    @Select("select count(*) from studentqiandao where username=#{username}" +
            " and kechengmingcheng=#{kechengmingcheng}  and qiandaozhuangtai=#{qiandaozhuangtai}")
    public int chageshu(@Param("username")String username,
                        @Param("kechengmingcheng")String kechengmingcheng,
                        @Param("qiandaozhuangtai")int qiandaozhuangtai);
    //签到前验证签到码和签到时间
    //在学生签到表中，每名学生的每
    @Select("select * from studentqiandao where username=#{username}" +
            " and kechengmingcheng=#{kechengmingcheng} " +
            "and qiandaozhuangtai=#{qiandaozhuangtai}")
    public StudentQiandao qiandaoyanzheng(@Param("username")String username,
                                            @Param("kechengmingcheng")String kechengmingcheng,
                                          @Param("qiandaozhuangtai")int qiandaozhuangtai
                                           );



    //查询学生签到表中一共有多少条数据
    @Select("select count(*) from studentqiandao")
    public int counts();

//    @Select("select   *   from   studentqiandao  limit 1")
//    public int limit1();



    //查询超时项
    @Select("select * from studentqiandao")
    public StudentQiandao chaoshichuliqianchaxun();

//    select * from table limit m,n
//    其中m是指zhidao记录开始的index，从0开始，表示第一条记录
//    n是指从第m+1条开始，取n条。
//    注意这里limit后面的写法和其他的不一样，
    //查询某行的数据
    @Select("select * from studentqiandao  limit #{hang},1")
    public StudentQiandao limitmouhang(int hang);

    //改写数据
    @Update("update studentqiandao set qiandaozhuangtai=#{qiandaozhuangtai}")
    public void updateqian(int qiandaozhuangtai);

    //查询学生签到表中的第某一条数据
    @Select("select * from studentqiandao where id= #{number}")
    public StudentQiandao chaxunmouyitiao(int number);


    //学生查发给自己的通知
    @Select("select * from tongzhi where fugaibanji =#{fugaibanji}")
    public List<Tongzhi> studentchatongzhi(@Param("fugaibanji")String fugaibanji);





}
