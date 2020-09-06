package cn.wf.service.impl;

import cn.wf.dao.UserDao;
import cn.wf.pojo.User;
import cn.wf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {
//
    @Autowired
    private UserDao userDao;



    public List<User> findAll() {
        System.out.println("业务层：查询所有用户");
//        return null;
        return userDao.findAll();
    }


    public void saveUser(User user) {
        System.out.println("业务层：保存用户");
        userDao.saveUser(user);
    }

    @Override
    public void deleteUserById(User user) {
        System.out.println("业务层：根据id删除用户");
        userDao.deleteUserById(user);
    }

    @Override
    public void updateUserById(User user) {
        System.out.println("业务层：根据id修改用户");
        userDao.updateUserById(user);
    }


}
