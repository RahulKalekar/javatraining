package com.bankapp.service.aspect;

import com.bankapp.exceptions.AccountNotFoundException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
@Aspect
public class BankAccNotFoundAspect {
    private Logger logger=org.slf4j.LoggerFactory.getLogger(BankAccNotFoundAspect.class);
    @AfterThrowing(pointcut="execution(* com.bankapp.service.AccountService.getById(..))", throwing="ex")
    public void logBankAccNotFound(AccountNotFoundException ex){
        logger.error(ex.getMessage()+"jai hind");
    }
}
