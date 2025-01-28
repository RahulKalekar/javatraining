package com.training.model.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class MethodLogger {
    private static final Logger logger=LoggerFactory.getLogger(MethodLogger.class);

    @Around("@annotation(com.training.model.annotations.Loggable)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = point.proceed();
        logger.info("Method {} took {} ms to execute",
                ((MethodSignature) point.getSignature()).getMethod().getName(),
                System.currentTimeMillis() - start);

        return result;
    }
}
