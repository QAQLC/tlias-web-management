package com.tlias.entity;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Dept {

    private String id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
