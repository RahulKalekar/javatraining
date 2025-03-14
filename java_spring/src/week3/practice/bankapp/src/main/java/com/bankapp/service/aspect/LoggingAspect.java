package com.bankapp.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LoggingAspect {
    private Logger logger=org.slf4j.LoggerFactory.getLogger(LoggingAspect.class);
    @Around("@annotation(com.bankapp.service.aspect.Loggable)")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("---------Before");
        Object proceed =proceedingJoinPoint.proceed();
        System.out.println("--------after");
        return proceed;
    }

}
