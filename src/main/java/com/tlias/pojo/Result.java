package com.tlias.pojo;

import com.tlias.constant.ErrorMessage;
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
        return new Result(ErrorMessage.SUCCESS.getCode(), "success", Data);
    }
    public static  Result SUCCESS(String msg) {
        return new Result(ErrorMessage.SUCCESS.getCode(), msg, null);
    }
    public static Result SUCCESS () {
        return new Result(ErrorMessage.SUCCESS.getCode(), "success", null);
    }
    public static Result ERROR (String code, String msg) {
        return new Result(code, msg, null);
    }
}
