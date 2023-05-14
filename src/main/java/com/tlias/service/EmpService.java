package com.tlias.service;

import com.tlias.pojo.Emp;
import com.tlias.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工列表
 */
public interface EmpService {

    PageBean page(Integer page, Integer pageSize);

    PageBean simplePage(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void deleteByIds(List<Integer> ids);

    void insertEmp(Emp emp);

    Emp login(Emp emp);
}
