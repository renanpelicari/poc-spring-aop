package com.renanpelicari.aoptalk.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Before("@annotation(LogMethodExecution)")
    public void logMethodExecutionBegin(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        String argsAsString = Arrays.stream(joinPoint.getArgs()).map(Object::toString)
                .collect(Collectors.joining(","));
        log.info("BEGIN {}, args=[{}]", methodName, argsAsString);
    }

    @AfterReturning("@annotation(LogMethodExecution)")
    public void logMethodExecutionFinish(JoinPoint joinPoint, Object response) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        log.info("END {}, args=[{}]", methodName, response.toString());
    }
}