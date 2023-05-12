package com.tlias.controller;

import com.tlias.pojo.Emp;
import com.tlias.pojo.PageBean;
import com.tlias.pojo.Result;
import com.tlias.service.EmpService;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    /**
     * 员工类列表查询--原始方法
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
     */
    @GetMapping("/simpleEmps")
    public Result simplePage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize,
            String name,
            Short gender,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end)
    {
        log.info("员工列表查询:{}, {}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.simplePage(page, pageSize, name, gender, begin, end);
        return Result.SUCCESS(pageBean);
    }

    /**
     * 根据ids 删除部门员工
     * @param ids int id || List<int>
     */
    @DeleteMapping("/{ids}")
    public Result deleteByIds(@PathVariable List<Integer> ids) {
        log.info("根据ID删除员工：{}", ids);
        empService.deleteByIds(ids);
        return Result.SUCCESS();
    }

    /**
     * 新增员工
     * @param emp 员工实体类
     * @return 是否成功
     */
    @PostMapping
    public Result insertEmp (@RequestBody @Validated Emp emp) {
        log.info("新增员工：{}", emp);
        empService.insertEmp(emp);
        return Result.SUCCESS();
    }
}
