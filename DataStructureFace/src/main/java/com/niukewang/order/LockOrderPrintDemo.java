package com.niukewang.order;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cm
 * @create 2021/8/24-12:27 上午
 *
 * 开启两个线程A,B打印1到10，线程A打印奇数
 *  * 线程B打印偶数
 *  这个是使用lock里面的condition来解决的
 */
public class LockOrderPrintDemo {
    static Thread threadA;
    static Thread threadB;
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        final int[] a = {0};
        threadA = new Thread(()->{
            int i = 1;
            lock.lock();
            try {
               while (i <= 9){
                   while (a[0] != 0){
                       conditionA.await();
                   }
                   System.out.println(Thread.currentThread().getName()+"->"+i);
                   i = i+2;
                   a[0] = 1;
                   conditionB.signal();
               }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"A");
        threadB = new Thread(()->{
            int i = 2;
            lock.lock();
            try {
                while (i <= 10){
                    while (a[0] != 1){
                        conditionB.await();
                    }
                    System.out.println(Thread.currentThread().getName()+"->"+i);
                    i = i+2;
                    a[0] = 0;
                    conditionA.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"B");
        threadA.start();
        threadB.start();
    }

}

class OrdeShareResource{

}
