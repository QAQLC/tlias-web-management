package com.tlias.mapper;

import com.tlias.entity.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * mybatis day09 增删改查 springboot-mybatis-crud
 */
@Mapper
public interface EmpMapper {
    /**
     * 删除员工Id 一个入参的时候这个形参可以随便写，列如#{value}
     * @param id 员工表中的主键
     */
    @Delete("delete from emp where id = #{value}")
    void deleteByEmpId (Integer id);

    /**
     * 新增一条员工
     * 问题，难不成实体类的属性一个个输入?
     * 新增的字段确实是一条条输入的，但是实体类的属性不需要额外.
     */
    @Insert("insert into emp values ()")
    void insertIntoEmp (Emp emp);
}
