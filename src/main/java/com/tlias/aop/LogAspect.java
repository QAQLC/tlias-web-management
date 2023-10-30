package com.tlias.aop;

import com.alibaba.fastjson.JSONObject;
import com.tlias.entity.OperateLog;
import com.tlias.mapper.OperateLogMapper;
import com.tlias.utils.JwtUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 记录用户操作日志
 */
@Slf4j
@Aspect // 切面类
@Component
public class LogAspect {
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private OperateLogMapper operateLogMapper;

    /**
     * 通知方法
     * @param proceedingJoinPoint 连接点
     * @return 函数返回值
     * @throws Throwable 错误
     */
    @Around("@annotation(com.tlias.anno.Log)")
    public Object recordLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 操作人id 当前登录人id
        String token = httpServletRequest.getHeader("token");
        Integer operateUser = (Integer) JwtUtils.parseJwt(token).get("id");
        // 操作时间
        LocalDateTime operateTime = LocalDateTime.now();
        // 操作类名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        // 操作方法名
        String methodName = proceedingJoinPoint.getSignature().getName();
        // 操作方法参数
        Object[] args = proceedingJoinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();
        // 方法返回值
        String returnValue = JSONObject.toJSONString(result);
        // 操作耗时
        long costTime = System.currentTimeMillis() - begin;
        OperateLog operateLog = new OperateLog(
            null,
            operateUser,
            operateTime,
            className,
            methodName,
            methodParams,
            returnValue,
            costTime
        );
        operateLogMapper.insert(operateLog);
        log.info("AOP记录日志：{}", operateLog);
        return result;
    }
}
