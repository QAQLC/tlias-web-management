package com.tlias.controller;

import com.tlias.entity.Dept;
import com.tlias.pojo.Result;
import com.tlias.service.DeptService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DeptController {
    @Resource
    private DeptService deptService;

    /**
     * 查询部门
     * @return 部门列表
     */
    @GetMapping("/depts")
    public Result list(){
        log.info("查询部门数据~");
        List<Dept> deptList = deptService.list();
        return Result.SUCCESS(deptList);
    }

    /**
     * 删除部门
     * @param id 部门id
     * @return 无
     */
    @DeleteMapping("/depts/{id}")
    public Result deleteDept(@PathVariable Integer id) {
        log.info("部门id{}：", id);
        deptService.deleteById(id);
        return Result.SUCCESS();
    }

    /**
     * 新增部门
     * @return 无
     */
    @PostMapping("/depts")
    public Result insertDept(String name) {
        log.info("部门名称：{}",name);
        deptService.insertDept(name);
        return Result.SUCCESS();
    }
}
