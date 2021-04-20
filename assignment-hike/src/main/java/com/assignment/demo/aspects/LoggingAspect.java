package com.assignment.demo.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(public * com.assignment.demo.controllers.*.*(..))")
    public void allControllerMethodExecutionPointCut(){}

    @Pointcut("execution(public * com.assignment.demo.service.*.*(..))")
    public void allServiceMethodExecutionPointCut(){}

    @Around("allControllerMethodExecutionPointCut() || allServiceMethodExecutionPointCut()")
    public Object aroundAspect(ProceedingJoinPoint pjp) throws Throwable {
        Long logID = System.nanoTime();
        log.info(" ###### Log ID : {} :: Before  Execution of Method {}.{} :: params {}  #####",logID,pjp.getSignature().getDeclaringTypeName(),pjp.getSignature().getName(), Arrays.toString(pjp.getArgs()));
        Object proceed = pjp.proceed(pjp.getArgs());
        log.info(" ###### Log ID: {} :: End Execution of Method {}.{} ::  Result {}  ####",logID,pjp.getSignature().getDeclaringTypeName(),pjp.getSignature().getName(), proceed);
        return proceed;
    }
}
