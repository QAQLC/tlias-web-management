package com.tlias.controller;

import com.tlias.pojo.Emp;
import com.tlias.pojo.Result;

import com.tlias.service.EmpService;
import com.tlias.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login (@RequestBody Emp emp) {
        log.info("用户登录查询：{}", emp);
        Emp e = empService.login(emp);
        // 生成令牌下发令牌
        if (e != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("userName", e.getName());

            String jwt = JwtUtils.generateJWT(claims);
            return Result.SUCCESS(jwt);
        }
        return Result.ERROR("账号密码错误");
    }
}
