package com.playdata.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 서블릿에 대한 처리 전에 실행되는 부분 request, response의 인코딩을 utf-8로 지정
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("UTF-8");

        // 요청이 들어올 때마다 실행되는 메소드 (기준점)
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
