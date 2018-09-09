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

    @Before(value = "execution(* org.yqj.aop.demo.service..*Service.*(..))")
    public void logServiceAccessBefore(JoinPoint joinPoint) {
        log.info("Before: " + joinPoint);
    }

    @AfterReturning(value = "execution(* org.yqj.aop.demo.service..*Service.*(..))")
    public void logServiceAccessAfter(JoinPoint joinPoint) {
        log.info("Completed: " + joinPoint);
    }

}
