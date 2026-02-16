package com.jobAppAop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component
@Aspect
public class PerformanceMonitoringAspect {
    public static final Logger LOGGER=LoggerFactory.getLogger(PerformanceMonitoringAspect.class);
@Around("execution(* com.jobAppAop.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
long start = System.currentTimeMillis();
Object obj = jp.proceed();
Long end = System.currentTimeMillis();
LOGGER.info("Time taken by "+jp.getSignature().getName()+" "+(end-start)+"ms");
return obj;
    }

}
