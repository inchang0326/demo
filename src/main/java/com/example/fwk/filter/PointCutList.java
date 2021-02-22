package com.example.fwk.filter;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutList {

    @Pointcut("execution(* com.example.demo..controller..*.*(..))")
    public void allController() {
        System.out.println("I am PointCut");
    }

    @Pointcut("execution(* com.example.demo..service..*.*(..))")
    public void allService() {
        System.out.println("I am PointCut");
    }
}
