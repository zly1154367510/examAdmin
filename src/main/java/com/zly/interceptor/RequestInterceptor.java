package com.zly.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zly11 on 2018/4/19.
 */
public class RequestInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("经过跨域请求头");
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("origin"));
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age","3600");
        response.setHeader("Access-Control-Allow-Headers","x-requested-with,Cache-Control,Pragma,Content-Type,Token");
        response.setHeader("Access-Control-Allow-Credentials","true");
        String method= request.getMethod();
        if (method.equals("OPTIONS")){
            response.setStatus(200);
            return true;
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
}
