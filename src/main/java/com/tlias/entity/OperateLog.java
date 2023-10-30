package com.tlias.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperateLog {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 操作人ID
     */
    private Integer operateUser;
    /**
     * 操作时间
     */
    private LocalDateTime operateTime;
    /**
     * 操作的类名
     */
    private String className;
    /**
     * 操作的方法名
     */
    private String methodName;
    /**
     * 操作方法的参数
     */
    private String methodParams;
    /**
     * 返回值
     */
    private String returnValue;
    /**
     * 方法执行时间
     */
    private Long costTime;
}
