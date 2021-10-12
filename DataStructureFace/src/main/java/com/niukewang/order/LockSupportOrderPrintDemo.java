package com.niukewang.order;

import java.util.concurrent.locks.LockSupport;

/**
 * @author cm
 * @create 2021/8/24-12:17 上午
 *
 * 开启两个线程A,B打印1到10，线程A打印奇数
 * 线程B打印偶数
 * 这个是使用LockSupport方法来解决的
 */
public class LockSupportOrderPrintDemo {
    static Thread threadA;
    static Thread threadB;
    public static void main(String[] args) {
        threadA = new Thread(()->{
            for (int i = 1; i <= 9; i += 2) {
                System.out.println(Thread.currentThread().getName()+"->"+i);
                LockSupport.unpark(threadB);
                LockSupport.park();
            }
        },"A");
        threadB = new Thread(()->{
            for (int i = 2; i <= 10; i += 2){
                LockSupport.park();
                System.out.println(Thread.currentThread().getName()+"->"+i);
                LockSupport.unpark(threadA);
            }
        },"B");
        threadA.start();
        threadB.start();
    }
}
