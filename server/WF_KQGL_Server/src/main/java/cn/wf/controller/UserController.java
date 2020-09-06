package cn.wf.controller;

import cn.wf.pojo.User;
import cn.wf.service.UserService;
import cn.wf.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
账户控制器
 */
/*
用户点击超链接或者按钮什么的，会自动发送请求，给controller，注意路径别写错就行，如("/usercontroller")("/findall")
controller用 依赖注入（前提是通过配置装入到Ioc容器中） 注入了service方法，
在controller方法中直接调service方法，有的service方法需要返回值，可以按Alt+Enter快速添加
需要在controller的方法添加参数 如findAll（Model model） Model就是参数，可以保存数据库中的数据，方便能转发到页面上。
在return之前用

 */
@Controller
@RequestMapping("/usercontroller")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findall")
    public String findAll(Model model) {
        System.out.println("表现层：查询所有信息");
        //调用service的方法
//        userService.findAll();
        List<User> list = userService.findAll();
//        if(list!=null){
//            for (User user : list) {
//                System.out.println(user);
//            }
//        }
        //重定向
        model.addAttribute("list", list);
        return "list";
    }

    /*
    方法上定义对象User user，就可以自动把前端发来的数据封装到对象中user中
    封装了对象user后，直接调  @Autowired private UserService userService;
    中的方法。

    前台发请求给controller，controller调service ，service调dao，dao通过注解
    把数据存到数据库

    如果想要重定向到查询数据的表，可以在方法saveusr()的()里面加入参数HttpServletResponse,
    就可以转发了
     */
    @RequestMapping("/saveuser")
    public void saveuser(User user ,HttpServletResponse response,HttpServletRequest request) throws IOException {
        System.out.println("表现层：保存新用户");
        userService.saveUser(user);
        response.sendRedirect(request.getContextPath()+"/usercontroller/findall");
        return;
    }


    @RequestMapping("/deleteuserbyid")
    public void deleteuserbyid(User user ,HttpServletResponse response,HttpServletRequest request) throws IOException {
        System.out.println("表现层：根据id删除某用户");
        userService.deleteUserById(user);
        response.sendRedirect(request.getContextPath()+"/usercontroller/findall");
        return;
    }

    @RequestMapping("/updateuserbyid")
    public void updateuserbyid(User user ,HttpServletResponse response,HttpServletRequest request) throws IOException {
        System.out.println("表现层：根据id修改某用户");
        userService.updateUserById(user);
        response.sendRedirect(request.getContextPath()+"/usercontroller/findall");
        return;
    }



//    给list.jsp添加一个返回到index.jsp页面的方法


    @RequestMapping("/back")
    public String back(){
        System.out.println("表现层：从list.jsp返回到index.jsp");
        return "index.jsp";
    }

}
