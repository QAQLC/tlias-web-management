package com.tlias.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Dept {
    private String id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
