package com.example.demo.filter;

import com.example.demo.pojo.TUserAccount;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Log4j2
@Component
@WebFilter(value = "SessionFilter",urlPatterns = "/*")
public class SessionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        //获取请求路径
        String requestURI=httpServletRequest.getRequestURI();
        log.info("requestURI{}：",requestURI);
        //那些请求需要放过
        if (requestURI.contains("css")||
            requestURI.contains("images")||
            requestURI.contains("js")||
            requestURI.contains("/finance/borrow/query")||
            requestURI.contains("/index.html")||
            requestURI.contains("/tpl-head.html")||
            requestURI.contains("/tpl-navnar.html")||
            requestURI.contains("/longin.html")||
            requestURI.contains("register.html")||
            requestURI.contains("ico")||
            requestURI.contains("/user/login")||
            requestURI.contains("/tpl-footer.html")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //进行session校验
            TUserAccount userAccount= (TUserAccount) httpServletRequest.getSession().getAttribute("userAccount");
            if (userAccount!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                log.info("用户未登录");
                servletRequest.getRequestDispatcher("login.html").forward(servletRequest,servletResponse);
            }
        }
    }
}
