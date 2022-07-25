package com.kaede.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author kaede
 * @create 2022-07-24 17:38
 */

@Component
public class LoggerAspect {

    public void beforeAdviceMethod(JoinPoint joinPoint) {
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect 方法：" + signature.getName() + " 参数：" + Arrays.toString(args));
    }

    public void afterAdviceMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect 方法：" + signature.getName() + " 执行完毕");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();

        System.out.println("LoggerAspect 方法：" + signature.getName() + " 结果：" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Exception e) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect 方法：" + signature.getName() + " 异常：" + e);
    }

    //环绕方法的返回值一定要和目标对象方法的 返回值一致
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            System.out.println("环绕通知 -> 前置通知");
            //表示目标对象方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知 -> 返回通知");
        } catch (Throwable e) {
            System.out.println("环绕通知 -> 异常通知");
            e.printStackTrace();
        } finally {
            System.out.println("环绕通知 -> 后置通知");
        }
        return result;
    }

}
