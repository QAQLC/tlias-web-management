package com.tlias.controller;

import com.tlias.anno.Log;
import com.tlias.entity.Dept;
import com.tlias.pojo.Result;
import com.tlias.service.DeptService;
import jakarta.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Resource
    private DeptService deptService;

    /**
     * 查询部门
     * @return 部门列表
     */
    @GetMapping
    public Result list() {
        log.info("查询部门数据~");
        List<Dept> deptList = deptService.list();
        return Result.SUCCESS(deptList);
    }

    /**
     * 删除部门
     * @param id 部门id
     * @return 无
     */
    @Log
    @DeleteMapping("/{id}")
    public Result deleteDept(@PathVariable Integer id) throws Exception {
        log.info("根据ID删除部门：{}", id);
        deptService.deleteById(id);
        return Result.SUCCESS();
    }

    /**
     * 新增部门
     * @return 无
     */
    @Log
    @PostMapping
    public Result insertDept(@RequestBody Dept dept) {
        log.info("新增部门：{}", dept);

        deptService.insertDept(dept);
        return Result.SUCCESS();
    }
}
