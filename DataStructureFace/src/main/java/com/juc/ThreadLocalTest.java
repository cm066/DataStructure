package com.juc;

import lombok.Data;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cm
 * @create 2021/10/24-6:26 下午
 */
public class ThreadLocalTest {

    @Data
    static class Foo{
        static final AtomicInteger AMOUNT = new AtomicInteger(0);
        int index = 0;
        int bar = 10;
        public Foo(){
            index = AMOUNT.incrementAndGet();
        }

        @Override
        public String toString() {
            return "Foo{" +
                    "index=" + index +
                    ", bar=" + bar +
                    '}';
        }
    }
    private static final ThreadLocal<Foo> FOO_THREAD_LOCAL = new ThreadLocal<>();
    //这个是设置一个默认的初始值
    private static final ThreadLocal<Foo> THREAD_LOCAL = ThreadLocal.withInitial(()->new Foo());
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,20,
                30, TimeUnit.SECONDS,new LinkedBlockingQueue<>(100));
        for (int i = 0; i < 5; i++) {
            executor.execute(()->{
                if (FOO_THREAD_LOCAL.get() == null){
                    FOO_THREAD_LOCAL.set(new Foo());
//                    FOO_THREAD_LOCAL.set(new Foo());
                }
                System.out.println("foo初始值："+FOO_THREAD_LOCAL.get());
                for (int j = 0; j < 10; j++) {
                    Foo foo = FOO_THREAD_LOCAL.get();
                    foo.setBar(foo.bar+1);
                }
                System.out.println("foo相加10次后的值："+FOO_THREAD_LOCAL.get());
                FOO_THREAD_LOCAL.remove();
            });

        }
    }
}
