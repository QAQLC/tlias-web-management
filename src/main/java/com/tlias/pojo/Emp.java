package com.tlias.pojo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 员工实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Emp {
    private Integer id;

    @NotNull(message = "账号不能为空！")
    private String username;
    private String password;
    @NotNull(message = "用户名不能为空！")
    private String name;
    @NotNull(message = "性别不能为空！")
    private Short gender;
    private String image;
    private Short job; // 职位 1 班主任 2 讲师 3 学工主管 4 教研主管 5 咨询师
    private Integer deptId; // 部门Id
    private LocalDate entrydate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
