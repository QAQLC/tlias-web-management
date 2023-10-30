package com.tlias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private Integer operateId;
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
     * 返回值
     */
    private String returnValue;
    /**
     * 方法执行时间
     */
    private Long costTime;

}
