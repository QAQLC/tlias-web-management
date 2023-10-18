package com.tlias.service.impl;

import com.tlias.entity.Dept;
import com.tlias.mapper.DeptMapper;
import com.tlias.service.DeptService;
import jakarta.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

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
    public void insertDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insertDept(dept);
    }
}
