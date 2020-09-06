package cn.wf.service.impl;

import cn.wf.dao.ChaKeBiaoDao;
import cn.wf.pojo.KeBiao;
import cn.wf.service.ChaKeBiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("chaKeBiaoService")
public class ChaKeBiaoServiceImpl implements ChaKeBiaoService {

    @Autowired
    private ChaKeBiaoDao chaKeBiaoDao;

    //查表
    public List<KeBiao> chakebiao(String username){
        return chaKeBiaoDao.chakebiao( username);
    }


}
