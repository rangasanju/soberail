package com.infyniteloop.soberail.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);


    @Before("execution(* com.infyniteloop.soberail.controller..*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {

        LOGGER.info("Executing - " + joinPoint.getClass() +"::" + joinPoint.getSignature());

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            try {
                LOGGER.info("Request : " + new ObjectMapper().writeValueAsString(arg));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }

//    @After("execution(* com.infyniteloop.soberail..*.*(..))")
//    public void logMethodExit(JoinPoint joinPoint) {
//
//        LOGGER.info("Exiting - " + joinPoint.getClass() +"::" + joinPoint.getSignature());
//    }

    @Around("execution(* com.infyniteloop.soberail..*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        LOGGER.info(joinPoint.getSignature().getName() + " executed in " + executionTime + "ms");
        return proceed;
    }
}