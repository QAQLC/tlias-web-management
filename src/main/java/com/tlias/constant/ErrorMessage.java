package com.tlias.constant;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    SUCCESS("0000", "成功"),
    ERROR("9999", "登陆过期")
    ;
    private final String code;
    private final String message;

    ErrorMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
