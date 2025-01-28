package com.book_app.services.aspect;

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
    private static final Logger logger = LoggerFactory.getLogger(MethodLogger.class);

    @Around("@annotation(com.book_app.annotations.Loggable)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        String methodName = signature.getMethod().getName();

        long start = System.currentTimeMillis();
//        Thread.sleep(1000);
        Object result = point.proceed();
        long end = System.currentTimeMillis();

        logger.info("Method {} took {} ms to execute.", methodName, (end - start));
        return result;
    }
}
