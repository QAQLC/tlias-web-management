package com.tlias.mapper;

import com.tlias.entity.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface  OperateLogMapper {
    @Insert(
        "insert into operate_log(operate_user, operate_time, class_name, method_name, return_value, cost_time)" +
        "values (#{operateUser}, #{operateTime}, #{className}, #{methodName}, #{returnValue}, #{costTime})"
    )
    void insert(OperateLog operateLog);
}
