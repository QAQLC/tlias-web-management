package com.tlias.controller;

import com.tlias.pojo.Emp;
import com.tlias.pojo.Result;
import com.tlias.service.EmpService;
import com.tlias.service.impl.EmpServiceImpl;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 解析xml
 * p74 Day05-请求响应-响应-案列
 * 使用三层架构重写这块的逻辑
 */
@RestController
public class EmpController {

    @Resource(name = "empServiceImpl") // 运行时，IOC容器会提供该类型的Bean对象，并赋值给该变量，依赖注入
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result listEmp() {
        List<Emp> empList = empService.listEmp();
        return Result.SUCCESS(empList);
    }
}
