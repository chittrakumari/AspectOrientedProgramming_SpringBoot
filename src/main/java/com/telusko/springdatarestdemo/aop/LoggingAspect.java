package com.telusko.springdatarestdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.telusko.springdatarestdemo.repo.JobRepo.*(..))")
    public void logMethodCall(){
        LOGGER.info("method called");
    }
}
