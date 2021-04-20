package com.assignment.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LoggingAspectTest {

    @Test
    void aroundAspect() throws Throwable {

        LoggingAspect loggingAspect = new LoggingAspect();
        ProceedingJoinPoint joinPoint = mock(ProceedingJoinPoint.class);
        MethodSignature signature = mock(MethodSignature.class);
        when(joinPoint.getSignature()).thenReturn(signature);
        when(signature.getMethod()).thenReturn(getClass().getDeclaredMethod("someMethod"));
        when(joinPoint.proceed(any())).thenReturn("Joint Point Result");
        loggingAspect.aroundAspect(joinPoint);
    }

    public void someMethod() {
    }
}