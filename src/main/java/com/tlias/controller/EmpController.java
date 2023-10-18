package com.tlias.controller;

import com.tlias.entity.PageBean;
import com.tlias.pojo.Result;
import com.tlias.service.EmpService;
import jakarta.annotation.Resource;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 解析xml
 * p74 Day05-请求响应-响应-案列
 * 使用三层架构重写这块的逻辑
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Resource
    private EmpService empService;

    @GetMapping()
    public Result page(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("分页请求如参数：page={}, pageSize={}", page, pageSize);
        PageBean pageBean = empService.page(page, pageSize);
        return Result.SUCCESS(pageBean);
    }
}
