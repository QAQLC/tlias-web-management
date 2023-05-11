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
    private String code;
    private String msg;
    private Object data;

    public static Result SUCCESS(Object Data) {
        return new Result("0000", "success", Data);
    }
    public static  Result SUCCESS(String msg) {
        return new Result("0000", msg, null);
    }
    public static Result SUCCESS () {
        return new Result("0000", "success", null);
    }
    public static Result ERROR (String code, String msg) {
        return new Result(code, msg, null);
    }
}
