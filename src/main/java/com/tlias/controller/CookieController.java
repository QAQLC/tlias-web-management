package com.tlias.controller;

import com.tlias.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CookieController {
    @GetMapping("/c1")
    public Result getCookie (HttpServletResponse response) {
        log.info("获取cookie");
        response.addCookie(new Cookie("itHeima", "123121"));
        return Result.SUCCESS();
    }
}
