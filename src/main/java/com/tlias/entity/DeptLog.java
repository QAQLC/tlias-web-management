package com.tlias.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 部门操作日志简单使用
 */
@Data
public class DeptLog {
    private Integer id;
    private LocalDateTime createTime;
    private String description;
}
