package com.tlias.controller;

import com.tlias.pojo.Dept;
import com.tlias.pojo.Result;
import com.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;
    /**
     * 部门列表查询
     * @return 部门列表全部
     */
    @GetMapping
    public Result list () {
        log.info("部门列表查询");
        List<Dept> deptList = deptService.list();
        return Result.SUCCESS(deptList);
    }

    /**
     * 删除部门
     * @param id 部门id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteById (@PathVariable Integer id) {
        log.info("根据ID删除部门:{}",id);
        deptService.deleteById(id);
        return Result.SUCCESS();
    }

    /**
     * 创建部门
     * @return
     */
    @PostMapping
    public Result add (@RequestBody Dept dept) {
         log.info("新增部门：{}", dept);
         deptService.add(dept);
         return Result.SUCCESS();
    }

    /**
     * 根据部门id查询部门
     * @return
     */
    @GetMapping("/{id}")
    public Result listById (@PathVariable Integer id) {
        log.info("根据ID查询部门{}", id);
        Dept dept = deptService.listById(id);
        return Result.SUCCESS(dept);
    }

    /**
     * 修改部门信息
     * @return
     */
    @PutMapping
    public Result updateById(@RequestBody Dept dept) {
        log.info("根据Id修改部门{}", dept);
        deptService.updateById(dept);
        return Result.SUCCESS();
    }
}
