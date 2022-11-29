package com.example.accessingdatamysql.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(public String com.example.accessingdatamysql.WebApp.printCourses())")
    public void beforeExecutionWebAppAdvice() {
        System.out.println("[log] starting web app with courses");
    }

    @Before("execution(* com.example.accessingdatamysql.WebApp..*(..)) )")
    public void hhe() {
        System.out.println("[log] web app 2 starting");
    }
}
