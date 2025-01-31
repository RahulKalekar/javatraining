package com.bank.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    @Before("execution(* com.bank.service.*.*(..))")
    public void logMethodExecution(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info("Executing method: " + joinPoint.getSignature().getName());
    }
    @AfterReturning(pointcut = "execution(* com.bank.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint) {
        logger.info("Completed: " + joinPoint.getSignature().toShortString());
    }
}
