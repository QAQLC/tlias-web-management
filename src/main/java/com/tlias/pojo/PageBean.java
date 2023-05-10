package com.tlias.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PageBean {
    private Long total; // 总页数
    private List rows; // 数据列表
}
