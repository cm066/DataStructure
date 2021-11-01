package com.mc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author cm
 * @create 2021/10/23-3:35 下午
 */
@Aspect
public class AspectJTest {

    @Pointcut("execution(* *.test(..))")
    public void test(){}

    @Before("test()")
    public void beforeTest(){
        System.out.println("beforeTest");
    }

    @After("test()")
    public void afterTest(){
        System.out.println("afterTest");
    }

    public Object aroundTest(ProceedingJoinPoint  p){
        System.out.println("before1");
        Object o = null;
        try {
            o = p.proceed();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("after1");
        return o;
    }
}
