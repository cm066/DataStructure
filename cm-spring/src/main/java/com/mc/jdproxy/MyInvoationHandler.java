package com.mc.jdproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author cm
 * @create 2021/10/23-4:07 下午
 */
public class MyInvoationHandler implements InvocationHandler {
    //目标对象
    private Object target;

    public MyInvoationHandler(Object target){
        super();
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----------before----------");

        Object result = method.invoke(target,args);
        System.out.println("------------after-----------");
        return result;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(),this);
    }
}
