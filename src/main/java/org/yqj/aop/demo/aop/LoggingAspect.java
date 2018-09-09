package org.yqj.aop.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author yaoqijun on 2018-04-08.
 */
@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut(value = "execution(* org.yqj.aop.demo.service..*Service.*(..))")
    public void helloWorldMethod(){}

    @Around(value = "helloWorldMethod()")
    public void around(ProceedingJoinPoint pjp) {
        log.info("around before execute proceed");
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
//            throwable.printStackTrace();
        }
        log.info("around after execute proceed");
    }

    public LoggingAspect(){
        log.info("logging aspect construct ... ");
    }

    @Before(value = "execution(* org.yqj.aop.demo.service..*Service.*(..)) && args(a1)", argNames = "a1")
    public void logServiceAccessBefore(JoinPoint joinPoint, String a1) {
        log.info("************** Before arg names is : " + a1);
        log.info("************** Before: " + joinPoint);
    }

    @After(value = "execution(* org.yqj.aop.demo.service..*Service.*(..)) && args(a1)")
    public void logServiceAccessAfter(JoinPoint joinPoint, String a1){
        log.info("************** return value is: " + a1);
        log.info("************** after: " + joinPoint);
    }

    @AfterReturning(value = "execution(* org.yqj.aop.demo.service..*Service.*(..))", returning = "rtv")
    public void logServiceAccessAfterReturning(JoinPoint joinPoint, String rtv) {
        log.info("************** after returning value is " + rtv);
        log.info("************** after returning: " + joinPoint);
    }

    @AfterThrowing(value = "execution(* org.yqj.aop.demo.service..*Service.*(..))", throwing = "ex")
    public void logServiceAccessAfterReturningThrow(JoinPoint joinPoint, Exception ex) {
        log.info("************** after returning throwing: " + joinPoint, ex);
    }
}
