package com.tlias.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// @WebFilter("/*")
public class DemoFilter implements Filter {

    @Override
    public void doFilter(
        ServletRequest servletRequest,
        ServletResponse servletResponse,
        FilterChain filterChain
    ) throws IOException, ServletException {
        log.info("拦截到了请求");

        filterChain.doFilter(servletRequest, servletResponse);
        log.info("拦截到了响应");
    }
}
