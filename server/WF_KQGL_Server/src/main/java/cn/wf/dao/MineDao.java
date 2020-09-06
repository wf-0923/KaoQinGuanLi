package cn.wf.dao;

import cn.wf.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MineDao {

    //自动查询已经登录的用户的基本资料
    @Select("select * from user where username=#{username}")
    public User chaxunyidengluyonghujibenziliao(@Param("username")String username);

    //mine
    @Select("select * from user where username=#{username}")
    public List<User> mine(@Param("username")String username);


}
