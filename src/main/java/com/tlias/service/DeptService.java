package com.tlias.service;

import com.tlias.entity.Dept;
import java.util.List;
import org.springframework.stereotype.Service;

public interface DeptService {
    List<Dept> list();

    void deleteById(Integer id);

    void insertDept(Dept dept);
}
