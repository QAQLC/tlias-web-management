package com.tlias.Mapper;

import com.tlias.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select count(*) from emp")
    Long count();

    @Select("select * from emp limit #{start}, #{pageSize}")
    List<Emp> page(Integer start, Integer pageSize);

    List<Emp> list (String name, Short gender, LocalDate begin, LocalDate end);

    void deleteByIds(List<Integer> ids);

    void insertEmp(Emp emp);
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

    /**
     * 根据部门id删除部门下的员工数据
     * @param deptId 部门id
     */
    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
