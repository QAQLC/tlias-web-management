package com.tlias.controller;

import com.tlias.pojo.Emp;
import com.tlias.pojo.Result;
import com.tlias.utils.XmlParseUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 解析xml
 * p74 Day05-请求响应-响应-案列
 */
@RestController
public class EmpController {
    @RequestMapping("/listEmp")
    public Result listEmp () {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        // 1.获取类路径下的emp.xml
        List<Emp> empList = XmlParseUtils.parse(file, Emp.class);

        empList.stream().forEach( emp  -> {
            String  gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            } else {
                emp.setGender("女");
            }
            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob(("讲师"));
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else {
                emp.setJob("就业指导");
            }
        });
        return Result.SUCCESS(empList);
    }
}
