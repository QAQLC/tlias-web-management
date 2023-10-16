package com.tlias.service;

import com.tlias.entity.Dept;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {
    List<Dept> list();

    void deleteById(Integer id);

    void insertDept(Dept dept);
}
