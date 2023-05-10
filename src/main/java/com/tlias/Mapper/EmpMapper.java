package com.tlias.Mapper;

import com.tlias.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    /**
     * 查询全部部门信息
     * @return 全部部门
     */
    @Select("select * from emp")
    List<Emp> list();
}
