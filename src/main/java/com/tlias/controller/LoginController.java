package com.tlias.controller;

import com.tlias.entity.Emp;
import com.tlias.pojo.Result;
import com.tlias.service.EmpService;
import com.tlias.utils.JwtUtils;
import jakarta.annotation.Resource;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Resource
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp e) {
        Emp emp = empService.login(e.getUsername(), e.getPassword());
        if (emp != null) {
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id", emp.getId());
            claims.put("name", emp.getName());

            String token = JwtUtils.generateJwt(claims);
            return Result.SUCCESS(token);
        }
        return Result.ERROR("用户名或密码错误", "9999");
    }
}
