package com.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * 这个适用于多任务依次执行的场景
 * todo 了解其原理
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(7, () -> {
            System.out.println("集齐七颗龙珠，召唤神兽");
        });
        for (int i = 1; i <= 7; i++) {
            new Thread(()->{
                System.out.println("集齐第"+Thread.currentThread().getName()+"颗龙珠");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
