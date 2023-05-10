package com.tlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public static Result SUCCESS(Object Data) {
        return new Result(0, "success", Data);
    }
    public static Result SUCCESS () {
        return new Result(0, "success", null);
    }
    public static Result ERROR () {
        return new Result(1, "error", null);
    }
}
