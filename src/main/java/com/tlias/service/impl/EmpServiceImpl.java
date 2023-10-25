package com.tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tlias.entity.Emp;
import com.tlias.entity.PageBean;
import com.tlias.mapper.EmpMapper;
import com.tlias.service.EmpService;
import jakarta.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;

    @Override
    public PageBean pageList1(Integer PageIndex, Integer PageSize) {
        Long count = empMapper.count();

        PageIndex = (PageIndex - 1) * PageSize;
        List<Emp> empList = empMapper.pageList1(PageIndex, PageSize);

        return new PageBean(count, empList);
    }

    @Override
    public PageBean pageList2(Integer page, Integer pageSize) {
        // 设置插件
        PageHelper.startPage(page, pageSize);
        // 查询数据
        List<Emp> empList = empMapper.pageList2();
        // 强转类型
        Page<Emp> p = (Page<Emp>) empList;
        // 返回数据
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public PageBean list(
        Integer page,
        Integer pageSize,
        String name,
        Short gender,
        LocalDate begin,
        LocalDate end
    ) {
        PageHelper.startPage(page, pageSize);
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        empMapper.deleteByIds(ids);
    }

    @Override
    public void insertEmp(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insertEmp(emp);
    }

    @Override
    public Emp login(String username, String password) {
        return empMapper.login(username, password);
    }
}
