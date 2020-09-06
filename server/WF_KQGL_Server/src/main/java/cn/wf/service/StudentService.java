package cn.wf.service;

import cn.wf.pojo.StudentQiandao;
import cn.wf.pojo.StudentQingjia;
import cn.wf.pojo.Tongzhi;
import cn.wf.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import javax.servlet.http.HttpSession;
import java.util.List;

public interface StudentService {

    //保存一个请假
    public void submitqingjia(String username, String name, String suozaibanji , String suozaixueyuan,
                              String qingjialeixing, String starttime, String overtime, String qingjialiyou);
    //搜索请假
    public List<StudentQingjia> sousuoqingjia(String username);

    //查0的个数
    public int chageshu(String username,String kechengmingcheng,int qiandaozhuangtai);

    //签到 改0为1
    public StudentQiandao studentqiandao(int qiandaozhuangtai,int qiandaozhuangtai2,String username,String kechengmingcheng);

    //签到前验证
    public StudentQiandao qiandaoyanzheng(String username,String kechengmingcheng,int qiandaozhuangtai);

    //学生查发给自己的通知
    public List<Tongzhi> studentchatongzhi(String fugaibanji);




}
