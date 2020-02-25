package com.example.demo.controller;

import com.example.demo.intrecaptor.SessionIntercaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configurable
public class SessionIntercaptorConfig implements WebMvcConfigurer {

    @Autowired
    private SessionIntercaptor sessionIntercaptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> list = Arrays.asList("/index.html",
                "/register.html", "/tpl-navbar.html",
                "/tpl-head.html", "/tpl-footer.html",
                "/js/*", "/css/*", "/images"
                , "/error","/login.html","/user/login");
        registry.addInterceptor(sessionIntercaptor).excludePathPatterns(list).addPathPatterns("/*");
    }
}

