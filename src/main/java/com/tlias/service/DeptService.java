package com.tlias.service;

import com.tlias.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {


    List<Dept> list();

    void deleteById(Integer id);

    void add(Dept dept);

    Dept listById(Integer id);

    void updateById(Dept dept);
}
