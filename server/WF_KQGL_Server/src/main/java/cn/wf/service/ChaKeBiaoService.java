package cn.wf.service;

import cn.wf.pojo.KeBiao;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ChaKeBiaoService {

    //查表
    public List<KeBiao> chakebiao(String username);



}
