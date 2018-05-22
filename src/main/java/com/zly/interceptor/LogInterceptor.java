package com.zly.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by zly11 on 2018/5/15.
 */
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //  System.out.println("我是登录拦截器");
        HttpSession session = httpServletRequest.getSession();
        // System.out.println("我是拦截器session"+session.getId());
        if (session.getAttribute("username")!=null){
            if (!session.getAttribute("username").equals("")){
                return true;
            }

        }
        httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest,httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
