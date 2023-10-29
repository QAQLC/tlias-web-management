package com.tlias.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeptLog {
    private Integer id;
    private LocalDateTime createTime;
    private String description;
}
