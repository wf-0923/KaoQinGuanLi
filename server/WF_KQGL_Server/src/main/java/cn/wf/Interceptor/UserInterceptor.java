package cn.wf.Interceptor;

import cn.wf.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * 在请求处理之前进行调用（Controller方法调用之前）
 */

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //获取请求的uri:去除http:localhost:8080这部分剩下的
        String uri = request.getRequestURI();
        //UTL:除了login.jsp是可以公开访问的，其他的URL都进行拦截控制
        //请求的url内  login”的位置，返回的是一个数字，代表出现的位置，-1表示不存在。>=0即存在，即是login的请求
        if (uri.indexOf("/loginin")>0||uri.indexOf("/register")>0) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("拦截器:检测前端请求为登录或注册，拦截通过");
            return true;
        }
        // 获取session
//      request.getSession()可以帮你得到HttpSession类型的对象
        HttpSession session = request.getSession();
//      User user = (User) session.getAttribute("USER_SESSION");
        //判断session中是否有用户数据，如果有，则返回true，继续向下执行
        if (session != null) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("拦截器:该用户已经登录,通过拦截,用户为:"+session.getAttribute("loginsuccess"));
            return true;
        }
        System.out.println("---------------------------------------------------------------------");
        //不符合条件的给出提示信息，并转发到登录页面
//        request.setAttribute("msg", "您还没有登录，请先登录！");
//        request.getRequestDispatcher("/login.jsp").forward(request, response);
        System.out.println("检测到没有登录，需要先登录");
        return false;
    }



//    后面这2个方法没用到，我只需要在请求发送前判断用户是否登录，即可，
    @Override
     public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
           }

         @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

           }

}
