package com.tlias.mapper;

import com.tlias.pojo.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * mybatis 入门层序
 */
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> listUser();
}
