package com.tlias.service.impl;

import com.tlias.entity.DeptLog;
import com.tlias.mapper.DeptLogMapper;
import com.tlias.service.DeptLogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {
    @Resource
    private DeptLogMapper deptLogMapper;
    /**
     * 记录部门日志
     * @param deptLog 部门日志
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}
