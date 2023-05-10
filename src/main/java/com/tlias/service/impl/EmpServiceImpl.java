package com.tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tlias.Mapper.EmpMapper;
import com.tlias.pojo.Emp;
import com.tlias.pojo.PageBean;
import com.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        Long total = empMapper.count();
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.page(start, pageSize);
        PageBean pageBean = new PageBean();
        pageBean.setRows(empList);
        pageBean.setTotal(total);
        return pageBean;
    }

    @Override
    public PageBean simplePage(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page, pageSize);
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        empMapper.deleteByIds(ids);
    }
}
