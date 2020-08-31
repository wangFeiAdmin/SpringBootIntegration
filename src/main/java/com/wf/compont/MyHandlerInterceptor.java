package com.wf.compont;


import com.wf.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 配置拦截器
 */
public class MyHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null){
            return true;
        }else{
            //拦截请求，提示错误信息
            request.setAttribute("mss","非法登录");
            //返回登录界面
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
    }
}
