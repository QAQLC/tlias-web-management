package com.tlias.controller;

import com.tlias.pojo.Emp;
import com.tlias.pojo.Result;
import com.tlias.utils.XmlParseUtils;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 解析xml
 * p74 Day05-请求响应-响应-案列
 */
@RestController
public class EmpController {

    @RequestMapping("/listEmp")
    public Result listEmp() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        // 获取数据持久层的数据
        List<Emp> empList = XmlParseUtils.parse(file, Emp.class);
        empList.forEach(emp -> {
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            } else {
                emp.setGender("女");
            }
            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else {
                emp.setJob("就业老师");
            }
        });
        return Result.SUCCESS(empList);
    }
}
