package com.tlias.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageBean {

    private Long total;
    private List<Emp> rows;
}
