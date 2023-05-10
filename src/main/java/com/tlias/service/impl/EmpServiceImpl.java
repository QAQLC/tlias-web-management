package com.tlias.service.impl;

import com.tlias.Mapper.EmpMapper;
import com.tlias.pojo.Emp;
import com.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 将对象交给IOC容器管理
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Emp> list() {
        return empMapper.list();
    }
}
