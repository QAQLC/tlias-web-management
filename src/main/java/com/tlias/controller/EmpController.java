package com.tlias.controller;

import com.tlias.pojo.PageBean;
import com.tlias.pojo.Result;
import com.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    /**
     * 员工类列表查询--原始方法
     * @return
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("员工列表查询:{}, {}", page, pageSize);
        PageBean pageBean = empService.page(page, pageSize);
        return Result.SUCCESS(pageBean);
    }

    /**
     * 员工类列表查询--使用PageHelper插件
     * @return
     */
    @GetMapping("/simpleEmps")
    public Result simplePage(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("员工列表查询:{}, {}", page, pageSize);
        PageBean pageBean = empService.simplePage(page, pageSize);
        return Result.SUCCESS(pageBean);
    }
}
