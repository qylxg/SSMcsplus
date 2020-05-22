package com.swjd.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//自定义拦截器
public class LoginInterceptor implements HandlerInterceptor {
    //用来做拦截的方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //发送请求获取地址
        String requestUri=request.getRequestURI();//获取请求地址
        //1.如果是登录页面我们就放行(>=0包含)
        if (requestUri.indexOf("login")>=0||requestUri.indexOf("Login")>=0){
            return true;
        }

        if (requestUri.indexOf("main") >= 0 || requestUri.indexOf("Main") >= 0) {
            return true;//放行
        }
        //2.如果用户登录过也放行
        //先获取session
        HttpSession session=request.getSession();
        //判断他是否登录
        if (session.getAttribute("activeName")!=null){
            return true;
        }

        //如果两种都不过就不放行并且让他回到登录页面
        request.getRequestDispatcher("/toLogin").forward(request,response);//将地址转发到登录页面
        return false;//false表示不通过，true表示页面通过，放行
    }
}
