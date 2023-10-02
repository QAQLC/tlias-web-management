package com.tlias;

import com.tlias.entity.Emp;
import com.tlias.mapper.EmpMapper;
import com.tlias.mapper.UserMapper;
import jakarta.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TliasWebManagementApplicationTests {

    @Resource
    private UserMapper userMapper;

    /**
     * mybatis 入门程序测试
     */
    @Test
    void TestListUser() {
        userMapper.listUser().forEach(System.out::println);
    }

    @Resource
    private EmpMapper empMapper;

    @Test
    void TestDeleteByEmpId() {
        empMapper.deleteByEmpId(16);
    }

    @Test
    void TestInsertIntoEmp() {
        Emp emp = new Emp();
        emp.setUsername("Jane");
        emp.setName("成李");
        emp.setGender((short) 1);
        emp.setImage("1.png");
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2018, 10, 19));
        emp.setDeptId(2);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insertIntoEmp(emp);
    }
    @Test
    void TestUpdateByEmpId() {
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("Jane");
        emp.setName("李成");
        emp.setGender((short) 1);
        emp.setImage("1.png");
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2018, 10, 19));
        emp.setDeptId(3);
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.updateByEmpId(emp);
    }

    @Test
    void TestUpdateByEmpIdDynamic() {
        Emp emp = new Emp();
        emp.setId(18);

        emp.setUsername("TLovers");
        emp.setName("李大锤");
        emp.setGender((short) 2);

        emp.setUpdateTime(LocalDateTime.now());

        empMapper.updateByEmpIdDynamic(emp);
    }

    @Test
    void TestQueryByEmpId() {
        Emp emp = empMapper.queryByEmpId(18);
        System.out.println(emp);
    }

    @Test
    void TestQueryListEmp() {
        List<Emp> temps = empMapper.queryListEmp("张无忌", (short) 1, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));
        System.out.println(temps);
    }

    @Test
    void TestQueryListEmpDynamic() {
        List<Emp> temps = empMapper.queryListEmpDynamic("null", (short) 2,
                LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));

    }

    /**
     * 批量删除员工id
     */
    @Test
    void TestDeleteByBatchEmpIds() {
        List<Integer> ids = Arrays.asList(15,16);
        empMapper.deleteByBatchEmpIds(ids);
    }
}
