package com.tlias.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimeAspect {

    /**
     * 统计连接点执行耗时
     * @param joinPoint 连接点
     * @return 连接点执行结果
     */
    @Around("execution(* com.tlias.service.impl.*.*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("连接点{}方法执行：耗时{}ms", joinPoint.getSignature().getName(), end - begin);
        return result;
    }
}
