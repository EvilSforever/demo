package com.example.demo.intrecaptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Log4j2
public class SessionIntercaptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入SessionIntercaptor");
        String requestURI=request.getRequestURI();
        log.info("requesURI：{}",requestURI);
        Object userAccount=request.getSession().getAttribute("userAccount");
        if (userAccount!=null){
            log.info("用户登录");
            return true;
        }else{
            log.info("用户未登录");
            return false;
        }
    }
}
