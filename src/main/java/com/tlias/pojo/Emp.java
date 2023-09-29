package com.tlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * xml解析员工信息的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

    private String name;
    private Integer age;
    private String image;
    private String gender;
    private String job;
}
