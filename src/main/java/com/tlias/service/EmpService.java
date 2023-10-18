package com.tlias.service;

import com.tlias.entity.PageBean;
import com.tlias.pojo.Emp;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmpService {
    PageBean page(Integer pageIndex, Integer pageSize);
}
