package com.tlias.aop;

import com.tlias.entity.OperateLog;
import com.tlias.mapper.OperateLogMapper;
import com.tlias.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 记录用户操作日志
 */
@Slf4j
@Aspect // 切面类
@Component
public class LogAspect {
    private HttpServletRequest httpServletRequest;

    private OperateLogMapper operateLogMapper;

    /**
     * 通知方法
     * @param proceedingJoinPoint 连接点
     * @return 函数返回值
     * @throws Throwable 错误
     */
    @Around("@annotation(com.tlias.anno.Log)")
    public Object recordLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String token = httpServletRequest.getHeader("token");
        Integer operateId = (Integer) JwtUtils.parseJwt(token).get("id");

        LocalDateTime operateTime = LocalDateTime.now();

        Object[] argsList = proceedingJoinPoint.getArgs();
        String args = Arrays.toString(argsList);

        Object result = proceedingJoinPoint.proceed();

        OperateLog operateLog = new OperateLog();
        operateLogMapper.insert(operateLog);
        return result;

    }
}
