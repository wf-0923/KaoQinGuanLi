package cn.wf.dao;


import cn.wf.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogInDao {

    //找到前端登录用户名
    @Select("select * from user where username=#{username}")
    public User checkusername(@Param("username")String username);

    //注册新用户
    @Select("insert into user (username,password,level,name,suozaixueyuan,suozaibanji,suoshuzhuanye)" +
            " values (#{username},#{password},#{level},#{name},#{suozaixueyuan},#{suozaibanji},#{suoshuzhuanye})")
    public void register(@Param("username")String username,@Param("password")String password,@Param("level")int level,
                         @Param("name")String name, @Param("suozaixueyuan")String suozaixueyuan,
                         @Param("suozaibanji")String suozaibanji, @Param("suoshuzhuanye")String suoshuzhuanye);

    //注册前查询是否有重名
    @Select("select username from user where username=#{username}")
    public User checkregister(@Param("username")String username);
}
