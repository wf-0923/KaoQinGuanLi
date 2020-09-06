package cn.wf.service.impl;

import cn.wf.dao.StudentDao;
import cn.wf.pojo.StudentQiandao;
import cn.wf.pojo.StudentQingjia;
import cn.wf.pojo.Tongzhi;
import cn.wf.pojo.User;
import cn.wf.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//声明以下为StudentServiceImpl的内容，注入到Spring的Ioc容器中
@Service("studentService")
@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    public void submitqingjia(String username, String name, String suozaibanji,
                              String suozaixueyuan, String qingjialeixing,
                              String starttime, String overtime, String qingjialiyou) {
        System.out.println("业务层：正在把请假数据写入数据库");
       studentDao.submitqingjia(username, name, suozaibanji, suozaixueyuan,
               qingjialeixing, starttime, overtime, qingjialiyou);
        System.out.println("业务层：请假数据写入数据库成功");
    }

    public List<StudentQingjia> sousuoqingjia(String username) {
        System.out.println("业务层：查询的所有请假记录");
        return studentDao.sousuoqingjia(username);
    }
    public StudentQiandao studentqiandao(int qiandaozhuangtai, int qiandaozhuangtai2,
                                         String username,String kechengmingcheng) {
        System.out.println("业务层：学生要签到，改0为1");
        return studentDao.studentqiandao(qiandaozhuangtai, qiandaozhuangtai2,username,kechengmingcheng);
    }
    public int chageshu(String username,String kechengmingcheng,int qiandaozhuangtai){
        System.out.println("业务层：查0的个数");
        return studentDao.chageshu(username,kechengmingcheng,qiandaozhuangtai);
    }
    public StudentQiandao qiandaoyanzheng(String username,String kechengmingcheng,int qiandaozhuangtai) {
        System.out.println("业务层：签到前验证");
        return studentDao.qiandaoyanzheng(username,kechengmingcheng, qiandaozhuangtai);
    }



    //学生查发给自己的通知
    public List<Tongzhi> studentchatongzhi(String fugaibanji){
        return studentDao.studentchatongzhi(fugaibanji);
    }






}
