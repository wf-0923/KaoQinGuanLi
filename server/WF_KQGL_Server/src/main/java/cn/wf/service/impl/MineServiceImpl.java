package cn.wf.service.impl;

import cn.wf.dao.MineDao;
import cn.wf.pojo.User;
import cn.wf.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("mineServiceImpl")
public class MineServiceImpl implements MineService {

@Autowired
private MineDao mineDao;

    public List<User> mine(String username){
        return mineDao.mine(username);
    }
}
