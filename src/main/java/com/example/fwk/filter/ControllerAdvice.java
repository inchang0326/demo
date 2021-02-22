package com.example.fwk.filter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ControllerAdvice {

    @Before("PointCutList.allController()")
    public void before() {
        System.out.println("allController() before");
    }

    @After("PointCutList.allController()")
    public void after() {
        System.out.println("allController() after");
    }

    @Around("PointCutList.allController()")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("allController() around start");
        Object result = null;

        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        /*
            요청 사이드의 http 패킷을 Java EE 규격에 맞게 포맷팅 해준 것
         */

        String signatureName = pjp.getSignature().getDeclaringType().getSimpleName() + "." + pjp.getSignature().getName();

        System.out.println("Controller Start: " + signatureName + " By " + req.getRemoteAddr());

        // pjp를 통해 메소드명, 파라미터값 등을 알 수 있음
        pjp.getSignature();

        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("allController() around end");
        return result;
    }
}
