package com.tlias.service.impl;

import com.tlias.entity.Emp;
import com.tlias.entity.PageBean;
import com.tlias.mapper.EmpMapper;
import com.tlias.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer PageIndex, Integer PageSize) {
        Long count = empMapper.count();

        PageIndex = (PageIndex - 1) * PageSize;
        List<Emp> empList = empMapper.page(PageIndex, PageSize);

        return new PageBean(count, empList);
    }
}
