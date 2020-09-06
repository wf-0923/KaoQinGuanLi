package cn.wf.controller;

import cn.wf.pojo.User;
import cn.wf.service.LoginInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping
//这里用了@SessionAttributes，可以直接把model中的user(也就key)放入其中
//这样保证了session中存在user这个对象
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private LoginInService loginInService;

    //把登录的用户信息存放在servlet的session中才算是登录上了，不然只能算是界面的跳转，
    //为了后续实现其他功能时,能通过session.getAttribute("loginsuccess")直接得到用户名作为参数,
    // 所以用user.getUsername(),只保存用户名,
    //这是一个系统消息:"用户信息:123",就只有123,可以作为参数直接使用
    @RequestMapping(value = "/loginin", method = RequestMethod.POST)
    public String loginin(User user, HttpSession session) {
        System.out.println("表现层：有人想要登录了");
        user = loginInService.checkusername(user.getUsername(), user.getPassword());
        if (user != null) {
//            重定向
            if (user.getLevel() == 0) {
                System.out.println("学生： " + user.getUsername() + "  登录成功");
            } else if (user.getLevel() == 2) {
                System.out.println("教师： " + user.getUsername() + "  登录成功");
            } else if (user.getLevel() == 3) {
                System.out.println("班主任： " + user.getUsername() + "  登录成功");
            } else if (user.getLevel() == 4) {
                System.out.println("辅导员： " + user.getUsername() + "  登录成功");
            }

            session.setAttribute("loginsuccess", user.getUsername());
            System.out.println("用户信息:" + session.getAttribute("loginsuccess"));
            return "login/loginsuccess";
        }
        System.out.println("登录失败！账号或密码错误！");
        return "login/loginfail";
    }


    @RequestMapping("/register")
    public String register(User user) {
        System.out.println("表现层：有人注册");
        //先判断传来的数据是否为空
        //如果返回值为false
        if (user.getUsername().equals("") ||
                user.getPassword().equals("") ||
                user.getName().equals("") ||
                user.getSuozaixueyuan().equals("") ||
                user.getSuozaibanji().equals("") ||
                user.getSuoshuzhuanye().equals("")) {
            System.out.println("有一项为空，请重新输入");
            return "register/registerfail";
        } else {
            System.out.println("表现层：调用了业务层方法，正在检查是否已经存在该用户");
            if (loginInService.checkregister(user.getUsername()) == false) {
                System.out.println("表现层：用户不存在，向业务层发送账户数据");
                loginInService.register(user.getUsername(), user.getPassword(),
                        user.getLevel(), user.getName(), user.getSuozaixueyuan(),
                        user.getSuozaibanji(), user.getSuoshuzhuanye());
                return "register/registersuccess";
            } else {
                System.out.println("用户名已存在，请重新输入");
                return "register/registerfail";
            }
        }
    }
    //退出登录
    @RequestMapping("loginout")
    public String outLogin(HttpSession session) {
        //发现:点浏览器返回键的时候,会自动退出
        //通过session.invalidata()方法来注销当前的session
        System.out.println("用户:" + session.getAttribute("loginsuccess") + " 正在退出");
        session.invalidate();
        System.out.println("用户已经退出");
        return "login/login";
    }

}
