package com.tlias.filter;

import com.alibaba.fastjson.JSONObject;
import com.tlias.pojo.Result;
import com.tlias.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * 登录过滤器，过滤接口，判断token是否正确 servlet  javaWeb 3大组件
 */

@Slf4j
// @WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 1.获取请求的url
        String url = request.getRequestURI();
        // 2.判断请求url中是否包含login 如果包含说明是登陆操作
        if (url.contains("login")) {
             filterChain.doFilter(servletRequest, servletResponse);
             return;
        }
        // 3.获取请求头中的令牌
        String jwt = request.getHeader("token");
        // 4.判断令牌是否存在，如果不存在，则返回错误结果(未登录)
        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头token为空");
            String error = JSONObject.toJSONString(Result.ERROR("NOT_LOGIN"));
            response.setHeader("content-type", "application/json;charset=utf-8");
            response.getWriter().write(error);
            return;
        }
        // 5.解析jwt，如果失败则返回错误信息(未登录)
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            String error = JSONObject.toJSONString(Result.ERROR("NOT_LOGIN"));
            response.setHeader("content-type", "application/json; charset=utf-8");
            response.getWriter().write(error);
        }
        log.info("jwt解析正确");
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
