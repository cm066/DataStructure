package com.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


/**
 * todo 了解其原理
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("第" + Thread.currentThread().getName() + "个获得车位");
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println("第" + Thread.currentThread().getName() + "个离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}


