package com.tlias;

import com.tlias.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TliasWebManagementApplicationTests {
    @Resource
    private UserMapper userMapper;
    @Test
    void TestListUser () {
        userMapper.listUser().forEach(System.out::println);
    }
}
