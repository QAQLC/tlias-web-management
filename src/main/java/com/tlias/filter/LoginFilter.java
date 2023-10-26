package com.tlias.filter;

import com.alibaba.fastjson.JSONObject;
import com.tlias.pojo.Result;
import com.tlias.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(
        ServletRequest servletRequest,
        ServletResponse servletResponse,
        FilterChain filterChain
    ) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String url = req.getRequestURL().toString();
        log.info("开始拦截请求：{}", url);
        if (url.contains("/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        String token = req.getHeader("token");
        log.info("token：{}", token);
        try {
            JwtUtils.parseJwt(token);
        } catch (Exception e) {
            log.error("token解析失败：{}", e.getMessage());
            Result result = Result.ERROR("9999", "token解析错误");
            String error = JSONObject.toJSONString(result);
            res.setContentType("application/json;charset=utf-8");
            res.getWriter().write(error);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("过滤器放行");
    }
}
