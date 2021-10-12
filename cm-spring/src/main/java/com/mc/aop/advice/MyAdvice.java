package com.mc.aop.advice;


import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {

    public void before(){
        System.out.println("处理数据之前");
    }
    public void afterReturning(){
        System.out.println("这是后置通知（出现异常就不会执行）");
    }
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("这是环绕通知之前");
        Object proceed = joinPoint.proceed();
        System.out.println("这是环绕通知之后的部分");
        return proceed;
    }

    public void afterException(){
        System.out.println("这是异常");
    }

    public void after(){
        System.out.println("这个是后置通知（出现异常也会执行的）");
    }
}
