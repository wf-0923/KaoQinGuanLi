package cn.wf.service;

import cn.wf.pojo.User;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserService {

    //查询所有用户信息
    public List<User> findAll();

    //保存账户信息
    public void saveUser(User user);

    //根据id修改用户信息
    public void deleteUserById(User user);

    //根据id修改某用户
    public void updateUserById(User user);


}
