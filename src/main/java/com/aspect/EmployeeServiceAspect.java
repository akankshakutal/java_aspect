package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {

    @Before(value = "execution(* com.Controller.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        String param = "";
        Object[] arguments = joinPoint.getArgs();
        for (Object argument : arguments) {
            param = param.concat(argument.toString()).concat(" ");
        }
        System.out.println("Before method:" + joinPoint.getSignature() + param);
    }

    @After(value = "execution(* com.service.EmployeeService.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        String param = "";
        for (int args = 0; args < joinPoint.getArgs().length; args++) {
            param = param.concat(joinPoint.getArgs()[args].toString()).concat(" ");
        }
        System.out.println("After method:" + joinPoint.getSignature() + param);
    }
}