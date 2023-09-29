package com.tlias;

import com.tlias.mapper.EmpMapper;
import com.tlias.mapper.UserMapper;
import jakarta.annotation.Resource;
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
    void TestDeleteByEmpId () {
        empMapper.deleteByEmpId(16);
    }
}
