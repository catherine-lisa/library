package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/book/*")
public class login_filter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res=(HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String requestURI=req.getRequestURI();
        if(session.getAttribute("login_state")!=null||requestURI.indexOf("/login")!=-1){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            res.sendRedirect("/login");
        }
    }

}
