package com.itdr.configs;

import com.itdr.pojo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/backed/*")
public class FullFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //乱码处理
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String requestURI = ((HttpServletRequest) request).getRequestURI();
        String[] split=requestURI.split("/");

        //管理员权限校验
        if("login".equals(split[split.length-1])){
            //登陆页面直接放行
            chain.doFilter(request, response);
        }else {
            HttpSession session = ((HttpServletRequest) request).getSession();
            Users us = (Users) session.getAttribute("us");
            //其他页面都需要验证管理员信息和登录
            if(us==null||us.getType()!=1){
                request.getRequestDispatcher("/WEB-INF/noaccess.jsp").forward(request,response);
            }else {
                chain.doFilter(request, response);
            }

        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
