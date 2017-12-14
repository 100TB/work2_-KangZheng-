package com.example.interceptor;

import com.example.model.User;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Kang.Zheng on 2017/12/14.
 */
public class MyInterceptor  implements HandlerInterceptor {
    /**
     * 拦截前往管理员页面的请求，判断是否具有权限，若是管理员则放行
     * 否则判断是否登陆，若没有登陆转到登陆页面，登陆过后提示没有权限
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user=(User)request.getSession().getAttribute("loginInfo");
        if(user==null){
            response.sendRedirect("/hello");
            return false;
        }
        if(user.getRole().getId()==1){
            return true;
        }
        response.sendRedirect("/noAdmin");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
