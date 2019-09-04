package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {

    @Before(value = "execution(* com.service.EmployeeService.*(..)) and args(name,empId)")
    public void beforeAdvice(JoinPoint joinPoint, String name, String empId) {
        System.out.println("Before method:" + joinPoint.getSignature());
    }

    @After(value = "execution(* com.service.EmployeeService.*(..)) and args(name,empId)")
    public void afterAdvice(JoinPoint joinPoint, String name, String empId) {
        System.out.println("After method:" + joinPoint.getSignature());
    }

    @Before("@annotation(com.Loggable)")
    public void beforeAdvice(){
        System.out.println("logging at Annotation Pointcut Designators");
    }

    @Pointcut("execution(* com.service.EmployeeService.*(..)) and args(name,empId)")
    private void forController(){}


    @Around("forController() and args()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("Around advice");
        Object[] args = proceedingJoinPoint.getArgs();
        Object result = proceedingJoinPoint.proceed(args);
        System.out.println("Returning " + result);
    }
}