package org.yqj.aop.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author yaoqijun on 2018-04-08.
 */
@Aspect
@Component
@Slf4j
public class LoggingAspect {

    public LoggingAspect(){
        log.info("logging aspect construct ... ");
    }

    @Before("execution(* org.yqj.aop.demo.service..*Service.*(..))")
    public void logServiceAccessBefore(JoinPoint joinPoint) {
        System.out.println("Before: " + joinPoint);
    }

    @AfterReturning("execution(* org.yqj.aop.demo.service..*Service.*(..))")
    public void logServiceAccessAfter(JoinPoint joinPoint) {
        System.out.println("Completed: " + joinPoint);
    }

}
