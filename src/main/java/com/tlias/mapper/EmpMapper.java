package com.tlias.mapper;

import com.tlias.entity.Emp;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmpMapper {
    /**
     * 分页查询
     * @return 总页数
     */
    @Select("select count(*) from tb_emp")
    Long count();

    @Select("select * from tb_emp limit #{PageNum}, #{PageSize}")
    List<Emp> pageList1(Integer PageNum, Integer PageSize);

    @Select("select * from tb_emp")
    List<Emp> pageList2();

    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void deleteByIds(List<Integer> ids);

    void insertEmp(Emp emp);

    /**
     * 用户登录
     * @param username 账号
     * @param password 密码
     * @return
     */
    @Select("select * from tb_emp where username = #{username} and password = #{password}")
    Emp login(String username, String password);

    /**
     * 根据部门id删除员工
     * @param deptId 部门id
     */
    @Delete("delete from tb_emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
