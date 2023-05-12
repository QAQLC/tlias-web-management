package com.tlias.handler;

import com.tlias.constant.ErrorMessage;
import com.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;

@RestControllerAdvice
@Slf4j
public class ControllerHandlers {
    @ExceptionHandler(BindException.class)
    public void errorHandler (BindException bindException) {
        log.error(bindException.getMessage());
    }

    /**
     * 校验接口参数
     * 参数是否必填非空等
     * @param methodArgumentNotValidException
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result ValidationHandler (MethodArgumentNotValidException methodArgumentNotValidException) {
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        // 打印参数缺失详情
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String msg = String.format("%s%s;", fieldError.getField(), fieldError.getDefaultMessage());
            log.error(msg);
        }

        return Result.ERROR(bindingResult.getFieldError().getDefaultMessage());
    }
}
