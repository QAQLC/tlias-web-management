package com.tlias.service.impl;

import com.tlias.entity.Dept;
import com.tlias.mapper.DeptMapper;
import com.tlias.service.DeptService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void insertDept(String name) {
        Dept dept = new Dept();
        dept.setId(null);
        dept.setName(name);
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insertDept(dept);
    }
}
