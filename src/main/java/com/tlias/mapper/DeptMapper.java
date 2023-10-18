package com.tlias.mapper;

import com.tlias.entity.Dept;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeptMapper {
    @Select("select * from tb_dept")
    List<Dept> list();

    @Delete("delete from tb_dept where id = #{id}")
    void deleteById(Integer id);

    @Insert(
        "insert into tb_dept(id, name, create_time, update_time) values(null, #{name}, #{createTime}, #{updateTime})"
    )
    void insertDept(Dept dept);
}
