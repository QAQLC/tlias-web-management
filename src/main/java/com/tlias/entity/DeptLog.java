package com.tlias.entity;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * 部门操作日志简单使用
 */
@Data
public class DeptLog {

    private Integer id;
    private LocalDateTime createTime;
    private String description;
}
