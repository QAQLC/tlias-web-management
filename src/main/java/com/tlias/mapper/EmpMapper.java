package com.tlias.mapper;

import com.tlias.entity.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * mybatis day09 增删改查 springboot-mybatis-crud
 */
@Mapper
public interface EmpMapper {
    /**
     * 删除员工Id 一个入参的时候这个形参可以随便写，列如#{value}
     *
     * @param id 员工表中的主键
     */
    @Delete("delete from emp where id = #{value}")
    void deleteByEmpId(Integer id);

    /**
     * 新增一条员工
     * 问题，难不成实体类的属性一个个输入?
     * 新增的字段确实是一条条输入的，但是实体类的属性不需要额外的使用 实体类.属性名
     */
    @Insert(
            "insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
                    "values(#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})"
    )
    void insertIntoEmp(Emp emp);

    /**
     * 根据用户id更新用户数据
     * @param emp 实体类
     */
    @Update("update emp set username= #{username}, name = #{name}, gender = #{gender}, image = #{image}, job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId}, update_time = #{updateTime} where id = #{id}")
    void updateByEmpId(Emp emp);

    /**
     * 动态sql if案例
     * @param emp
     */
    void updateByEmpIdDynamic(Emp emp);
    /**
     * 根据用户id查询用户信息，编辑场景使用
     * @param id emp id
     * @return 员工信息
     */
    @Select("select * from emp where id = #{id}")
    Emp queryByEmpId(Integer id);

    /**
     * 条件查询，所有查询条件必传
     * @param name 员工姓名
     * @param gender 员工性别
     * @param beginDate 入职开始时间
     * @param endDate 入职结束时间
     * @return List<Emp>
     */
    List<Emp> queryListEmp(String name, Short gender, LocalDate beginDate, LocalDate endDate);

    /**
     * 动态sql查询
     * @param name 用户名
     * @param gender 性别
     * @param beginDate 入职开始时间
     * @param endDate 入职结束时间
     * @return List<Emp>
     */
    List<Emp> queryListEmpDynamic(String name, Short gender, LocalDate beginDate, LocalDate endDate);

    /**
     * 批量删除呢员工
     * @param ids 员工id
     */
    void deleteByBatchEmpIds(List<Integer> ids);
}
