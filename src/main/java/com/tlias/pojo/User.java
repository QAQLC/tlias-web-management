package com.tlias.pojo;

import lombok.Data;

/**
 * mybatis 入门相关案列
 */
@Data
public class User {
    private Integer id;
    private String name;
    private Short age;
    private Short gender;
    private String phone;
}
