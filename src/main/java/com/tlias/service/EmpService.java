package com.tlias.service;

import com.tlias.entity.Emp;
import com.tlias.entity.PageBean;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

public interface EmpService {
    PageBean pageList1(Integer pageIndex, Integer pageSize);
    PageBean pageList2(Integer page, Integer pageSize);

    PageBean list(
        Integer page,
        Integer pageSize,
        String name,
        Short gender,
        LocalDate begin,
        LocalDate end
    );

    void deleteByIds(List<Integer> ids);

    void insertEmp(Emp emp);
    Emp login(String username, String password);
}
