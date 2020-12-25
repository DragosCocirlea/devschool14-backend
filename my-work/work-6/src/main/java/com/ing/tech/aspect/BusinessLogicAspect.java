package com.ing.tech.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class BusinessLogicAspect {

    @Before("execution(* BusinessLogic.transferMoney())")
    public void before(JoinPoint joinPoint) {
        log.error("Before function");
    }

    @Around("execution(* BusinessLogic.*())")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.error("Around 1 function");

        joinPoint.proceed();

        log.error("Around 2 function");
    }

    @After("execution(* BusinessLogic.transferMoney())")
    public void after(JoinPoint joinPoint) {
        log.error("After function");
    }

}
