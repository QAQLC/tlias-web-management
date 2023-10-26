package com.tlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private Integer code;
    private String msg;
    private Object data;

    public static Result SUCCESS() {
        return new Result(1, "成功", null);
    }

    public static Result SUCCESS(Object data) {
        return new Result(1, "成功", data);
    }

    public static Result ERROR() {
        return new Result(0, "失败", null);
    }

    public static Result ERROR(String msg) {
        return new Result(0, msg, null);
    }

    public static Result ERROR(String msg, Object data) {
        return new Result(0, msg, data);
    }
}
