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
        return new Result(ErrorMessage.SUCCESS.getCode(), "成功", Data);
    }
    public static Result SUCCESS () {
        return new Result(ErrorMessage.SUCCESS.getCode(), "成功", null);
    }

    public static Result ERROR (String msg) {
        return new Result(ErrorMessage.ERROR.getCode(), msg, null);
    }
    public static Result ERROR () {
        return new Result(ErrorMessage.ERROR.getCode(), "失败", null);
    }
}
