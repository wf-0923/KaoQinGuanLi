package cn.wf.service;

import cn.wf.pojo.User;


public interface LoginInService {

    //登录
    public User checkusername(String username,String password);

    //注册
    public void register(String username,String password, int level,
                         String name,String suozaixueyuan,
                         String suozaibanji,String suoshuzhuanye);

    //检查是否有重名
    public boolean checkregister(String username);
}
