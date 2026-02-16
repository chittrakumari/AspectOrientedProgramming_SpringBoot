package com.jobAppAop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.jobAppAop.service.JobService.getAllJobs(..)) || execution(* com.jobAppAop.service.JobService.updateJob(..))")
    public void logMethodCall(){
        LOGGER.info("method called");
    }

    @After("execution(* com.jobAppAop.service.JobService.getAllJobs(..)) || execution(* com.jobAppAop.service.JobService.updateJob(..))")
    public void logMethodExcuted(JoinPoint jp){
        LOGGER.info("method executed "+jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.jobAppAop.service.JobService.getAllJobs(..)) || execution(* com.jobAppAop.service.JobService.updateJob(..))")
    public void logMethodCrashed(JoinPoint jp){
        LOGGER.info("method has issues "+jp.getSignature().getName());
    }
    @AfterReturning("execution(* com.jobAppAop.service.JobService.getAllJobs(..)) || execution(* com.jobAppAop.service.JobService.updateJob(..))")
    public void logMethodExecutedSuccess(JoinPoint jp){
        LOGGER.info("method exec successfully "+jp.getSignature().getName());
    }
}
