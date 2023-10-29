package com.tlias.service.impl;

import com.tlias.entity.Dept;
import com.tlias.entity.DeptLog;
import com.tlias.mapper.DeptMapper;
import com.tlias.mapper.EmpMapper;
import com.tlias.service.DeptLogService;
import com.tlias.service.DeptService;
import jakarta.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;
    @Resource
    private EmpMapper empMapper;
    @Resource
    private DeptLogService deptLogService;
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    /** 事务的一致性
     *  根据id删除部门
     * @param id 部门id
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer id) throws Exception {
        try {
            // 删除部门
            deptMapper.deleteById(id);
            // 主动抛出错误, 证明事务的一致性， 为了更加清晰的看到spring处理事务的过程，在配置文件中打开事务日志
            // int a = 1 / 0;

            // 验证事务是否只在RuntimeException进行回滚
            if (true) {
                throw new Exception("异常啦······");
            }
            // 删除部门下的员工
            empMapper.deleteByDeptId(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作,此次解散的是"+id+"号部门");

            deptLogService.insert(deptLog);
        }
    }

    @Override
    public void insertDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insertDept(dept);
    }
}
