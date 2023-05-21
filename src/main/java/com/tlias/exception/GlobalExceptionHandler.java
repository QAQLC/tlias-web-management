package com.tlias.exception;

import com.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;


/** 全局异常处理器
 * 错误异常处理，统一处理返给前端
 */
@Slf4j
@RestControllerAdvice // 全局异常处理器注解
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class) // 捕获的是哪一类型的异常，这里默认捕获所有的异常，捕获异常注解
    public Result errorHandler (Exception Exception) {
        log.error(Exception.getMessage());
        return Result.ERROR(Exception.getMessage());
    }

    /**
     * 校验接口参数
     * 参数是否必填非空等
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result ValidationHandler (MethodArgumentNotValidException methodArgumentNotValidException) {
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        log.info("参数校验错误：{}", methodArgumentNotValidException.getBindingResult());
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String msg = String.format("%s%s;", fieldError.getField(), fieldError.getDefaultMessage());
            log.error(msg);
        }
        return Result.ERROR(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
    }
}
