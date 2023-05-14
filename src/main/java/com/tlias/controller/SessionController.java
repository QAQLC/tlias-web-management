package com.tlias.controller;


import com.tlias.pojo.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SessionController {
    @GetMapping("/s1")
    public Result setSession (HttpSession session) {
        log.info("HttpSession-s1: {}", session.hashCode());
        session.setAttribute("loginUser", "tom");
        return Result.SUCCESS();
    }

    // 会话同步
    @GetMapping("/s2")
    public Result getSession (HttpServletRequest request) {
        HttpSession session = request.getSession();
        log.info("HttpSession-s2: {}", session.hashCode());
        Object loginUser = session.getAttribute("loginUser");
        log.info("loginUser: {}", loginUser);
        return Result.SUCCESS(loginUser);
    }

}
