package com.tlias.service.impl;

import com.tlias.dao.EmpDao;
import com.tlias.pojo.Emp;
import com.tlias.service.TestEmpService;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TestEmpServiceImpl implements TestEmpService {

    @Resource(name = "empDaoImpl")
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();
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
        return empList;
    }
}
