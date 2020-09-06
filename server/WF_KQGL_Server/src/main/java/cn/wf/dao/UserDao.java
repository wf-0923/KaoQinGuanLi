package cn.wf.dao;

import cn.wf.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
用户dao接口
 */
@Repository
public interface UserDao {

//mybatis可以帮我完成接口实现，就不用写实现类了    在服务实现类写 @Autowired  换行 private User user

    //查询所有用户信息
    @Select("select * from user")
    public List<User> findAll();


    //保存账户信息
    @Select("insert into user (username,password) values (#{username},#{password})")
    public void saveUser(User user);

    //根据id删除某用户
    @Delete("delete from user where id = #{id}")
    public void deleteUserById(User user);

//  例句：  update user set username = #{username}, birthday = #{birthday}, sex = #{sex}, address = #{address} where id = #{id}
    //根据id修改某用户
    @Update("update user set username = #{username} , password = #{password} where id = #{id}")
    public void updateUserById(User user);






    //注册新用户
    @Select("insert into user (username,password,level) values (#{username},#{password},#{level})")
    public void register(User user);

}
