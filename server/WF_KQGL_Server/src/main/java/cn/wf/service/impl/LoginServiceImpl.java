package cn.wf.service.impl;

import cn.wf.dao.LogInDao;
import cn.wf.pojo.User;
import cn.wf.service.LoginInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SignInService")
public class LoginServiceImpl implements LoginInService {

    @Autowired
    private LogInDao logInDao;


    public User checkusername(String username, String password) {
        System.out.println("业务层：有人登录，正在验证账号和密码");
        User user = logInDao.checkusername(username);
        //既然已经有了user，便只需再确认密码是否正确即可
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void register(String username, String password, int level,
                         String name, String suozaixueyuan,
                         String suozaibanji, String suoshuzhuanye) {
        System.out.println("业务层：确认无重名，开始注册");
        logInDao.register(username, password, level, name, suozaixueyuan, suozaibanji, suoshuzhuanye);
        System.out.println("业务层：用户" + username + "注册成功");
    }


    public boolean checkregister(String username) {
        if (logInDao.checkregister(username) == null) {
            return false;
        } else {
            return true;
        }
    }


}
