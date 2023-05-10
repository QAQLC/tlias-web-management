package com.tlias.Mapper;

import com.tlias.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select count(*) from emp")
    Long count();

    @Select("select * from emp limit #{start}, #{pageSize}")
    List<Emp> page(Integer start, Integer pageSize);

    @Select("select * from emp")
    List<Emp> list ();
}
