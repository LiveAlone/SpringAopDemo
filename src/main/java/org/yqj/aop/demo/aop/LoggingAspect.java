package org.yqj.aop.demo.aop;

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
public class LoggingAspect {

    @Before("execution(* org.yqj.aop.demo.service..*Service.*(..))")
    public void logServiceAccessBefore(JoinPoint joinPoint) {
        System.out.println("Before: " + joinPoint);
    }

    @AfterReturning("execution(* org.yqj.aop.demo.service..*Service.*(..))")
    public void logServiceAccessAfter(JoinPoint joinPoint) {
        System.out.println("Completed: " + joinPoint);
    }

}
