package cn.wf.service;

import cn.wf.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MineService {


    //mine
    public List<User>  mine(String username);

}
