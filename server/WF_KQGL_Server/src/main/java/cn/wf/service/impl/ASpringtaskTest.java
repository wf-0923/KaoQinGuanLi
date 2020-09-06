package cn.wf.service.impl;

import cn.wf.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

//我无法让Springtask通过for循环判断条件并修改数据库
//所以这个类算是废弃了
//变通：在学生完成签到之时之前，通过for方法，改写数据库

@Component
public class ASpringtaskTest {
    @Autowired
    private StudentDao studentDao;

    //initialDelay:服务启动后，多少毫秒启动该定时任务
    //fixedDelay:每隔多长时间执行一次定时任务
    @Scheduled(initialDelay = 1 * 1000, fixedDelay = 2700 * 1000)
    public void updateqiandaozhuangtai() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time = df.format(new Date());// new Date()为获取当前系统时间
        System.out.println(" -------------------------------定时任务 每45分钟一次--------------------------------");
        System.out.println("丨                                                                           丨");
        System.out.println("丨                         "+"当前系统时间为"+time+"                     丨");
        System.out.println("丨                            已经将学生签到表的数据更新                          丨");
        System.out.println("丨___________________________________________________________________________丨");
        studentDao.updateqian(2);

         /*
        思路：
        1.表中一共有多少条，
        2.从第一条开始，如果系统时间大于overtime，则运行一次更新

        总结：1.数据库从查询某一条的方法: select * from table limit m,n
               其中m是指zhidao记录开始的index，从0开始，表示第一条记录 n是指从第m+1条开始，取n条。
             2.计时器内的循环用do while 不要用for
         */



    }


}
