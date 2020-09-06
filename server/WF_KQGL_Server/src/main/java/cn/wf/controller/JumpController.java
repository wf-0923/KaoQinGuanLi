package cn.wf.controller;


import cn.wf.service.LoginInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
//这里用了@SessionAttributes，可以直接把model中的user(也就key)放入其中
//这样保证了session中存在user这个对象
@SessionAttributes("user")
public class JumpController {



    //跳转回登录成功页面
    @RequestMapping("tologinsuccess")
    public String tologinsuccess(HttpSession session) {
        System.out.println(session.getAttribute("loginsuccess") + "跳转回登录成功界面");
        return "login/loginsuccess";
    }
    //登陆失败重新登录
    @RequestMapping("relogin")
    public String relogin(HttpSession session) {
        System.out.println("重新登录");
        return "login/login";
    }
    //跳转到注册页面
    @RequestMapping("toregister")
    public String toregister(HttpSession session) {
        System.out.println("未登录：跳转到注册");
        return "register/register";
    }



    //公共功能区

    //跳转到我的

    @RequestMapping("tomine")
    public String tomine(HttpSession session) {
        System.out.println(session.getAttribute("loginsuccess") + "跳转到我的");
        return "mine/mine";
    }
    //跳转到课表
    @RequestMapping("tokebiao")
    public String tokebiao(HttpSession session) {
        System.out.println(session.getAttribute("loginsuccess") + "跳转到我的课表");
        return "kebiao/kebiao";
    }
    //    跳转到通知
    @RequestMapping("tostudenttongzhi")
    public String tostudenttongzhi(HttpSession session) {
        System.out.println(session.getAttribute("loginsuccess") + "跳转到通知");
        return "students/chatongzhi/chatongzhilist";
    }



    //学生功能区



    //    跳转到请假
    @RequestMapping("toqingjia")
    public String toqingjia(HttpSession session) {
        System.out.println(session.getAttribute("loginsuccess") + "跳转到请假");
        return "students/qingjia/shenqingqingjia";
    }

//    跳转到签到

    @RequestMapping("tostuqiandao")
    public String tostuqiandao(HttpSession session) {
        System.out.println(session.getAttribute("loginsuccess") + "跳转到签到");
        return "students/qiandao/stuqiandao";
    }


    //教师功能区

//    发布通知
@RequestMapping("fatongzhi")
public String tofatongzhi(HttpSession session) {
    System.out.println(session.getAttribute("loginsuccess") + "跳转到发布通知任务页");
    return "teachers/fatongzhi/teacherfatongzhi";
}

    //    发布签到任务
    @RequestMapping("toteacherfaqiandao")
    public String toteacherfaqiandao(HttpSession session) {
        System.out.println(session.getAttribute("loginsuccess") + "跳转到发布签到任务页");
        return "teachers/faqiandao/teacherfabuqiandaorenwu";
    }

    //跳转到成功发布签到的页面
    @RequestMapping("tofaqiandaosuccess")
    public String tofaqiandaosuccess(HttpSession session) {
        System.out.println(session.getAttribute("loginsuccess") + "跳转到发布签到成功页面");
        return "teachers/faqiandao/teacherfabuqiandaorenwusuccess";
    }


}




