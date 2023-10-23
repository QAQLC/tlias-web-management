package com.tlias.controller;

import com.tlias.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SessionController {
    /**
     * 设置cookie
     * @param response
     * @return
     */
    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response) {
        response.addCookie(new Cookie("name", "cookie"));
        return Result.SUCCESS();
    }
    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + ": " + cookie.getValue());
        }
        return Result.SUCCESS();
    }

    /**
     * 设置session
     * @param request
     * @return
     */
@GetMapping("/s1")
public Result session1(HttpServletRequest request) {
    HttpSession session = request.getSession();
    log.info("session id: {}, hashCode: {}", session.getId(), session.hashCode());
    session.setAttribute("name", "session");
    return Result.SUCCESS();
}
    @GetMapping("/s2")
    public Result session2(HttpServletRequest request) {
        HttpSession session = request.getSession();
        log.info("session id: {}, hashCode: {}", session.getId(), session.hashCode());
        System.out.println(request.getSession().getAttribute("name"));
        return Result.SUCCESS();
    }
}
