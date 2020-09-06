package cn.wf.dao;


import cn.wf.pojo.KeBiao;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChaKeBiaoDao {

    //查表
    @Select("select * from kebiao where username=#{username}")
    public List<KeBiao> chakebiao(@Param("username")String username);


}
