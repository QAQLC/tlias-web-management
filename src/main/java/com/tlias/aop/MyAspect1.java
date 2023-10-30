package com.tlias.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MyAspect1 {

    /**
     * 切入点表达式
     */
    @Pointcut(
        "execution(public void com.tlias.service.impl.DeptServiceImpl.deleteById(java.lang.Integer))"
    )
    public void pt() {}

    @Before("pt()")
    public void before() {
        log.info("MyAspect1 ...before...");
    }

    @After("pt()")
    public void after() {
        log.info("MyAspect1 ...after...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("MyAspect1 ...around...");
        return proceedingJoinPoint.proceed();
    }
}
