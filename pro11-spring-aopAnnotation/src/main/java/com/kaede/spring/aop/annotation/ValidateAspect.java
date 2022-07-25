package com.kaede.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author kaede
 * @create 2022-07-25 10:18
 */

@Component
@Aspect
@Order(1)
public class ValidateAspect {

    @Before("com.kaede.spring.aop.annotation.LoggerAspect.pointCut()")
    public void beforeMethod() {
        System.out.println("ValidateAspect -> 前置通知");
    }

}
