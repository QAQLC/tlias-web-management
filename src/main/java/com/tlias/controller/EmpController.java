package com.tlias.controller;

import com.tlias.entity.Emp;
import com.tlias.entity.PageBean;
import com.tlias.pojo.Result;
import com.tlias.service.EmpService;
import jakarta.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
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

    /**
     * 手动分页查询员工列表
     * @param page 页码
     * @param pageSize  页数
     * @return 员工列表
     */
    @GetMapping("/pageList")
    public Result pageList(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("分页请求参数：page={}, pageSize={}", page, pageSize);
        PageBean pageBean = empService.pageList1(page, pageSize);
        return Result.SUCCESS(pageBean);
    }

    /**
     * 使用PageHelper分页插件查询员工列表
     * @param page 页码
     * @param pageSize 页数
     * @return 员工列表
     */
    @GetMapping("/pageList2")
    public Result pageList2(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("分页请求参数：page={}, pageSize={}", page, pageSize);
        PageBean pageBean = empService.pageList2(page, pageSize);
        return Result.SUCCESS(pageBean);
    }

    /**
     * 查询员工列表
     * @param page 页码
     * @param pageSize 页数
     * @param name 姓名
     * @param gender 性别
     * @param begin 入职开始时间
     * @param end 入职结束时间
     * @return 员工列表
     */
    @GetMapping("/list")
    public Result list(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer pageSize,
        String name,
        Short gender,
        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
    ) {
        log.info(
            "分页请求参数：page={}, pageSize={}, name={}, gender={}, begin={}, end={}",
            page,
            pageSize,
            name,
            gender,
            begin,
            end
        );
        PageBean pageBean = empService.list(page, pageSize, name, gender, begin, end);
        return Result.SUCCESS(pageBean);
    }

    /**
     * 单条删除或者批量删除员工
     * @param ids 员工id
     * @return 成功
     */
    @DeleteMapping("/{ids}")
    public Result deleteByIds(@PathVariable List<Integer> ids) {
        log.info("员工ids：{}", ids);
        empService.deleteByIds(ids);
        return Result.SUCCESS();
    }

    /**
     * 新增员工
     * @param emp 员工实体
     * @return 成功 sava
     */
    @PostMapping
    public Result insertEmp(@RequestBody Emp emp) {
        log.info("员工信息：{}", emp);
        empService.insertEmp(emp);
        return Result.SUCCESS();
    }
}
