package com.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author cm
 * @create 2021/10/24-11:24 下午
 */
public class SynchronizedTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadSource threadSource = new ThreadSource();
        CountDownLatch downLatch = new CountDownLatch(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    threadSource.add();

                }
                System.out.println(Thread.currentThread().getName());
                downLatch.countDown();
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
        downLatch.await();
        System.out.println(threadSource.getSum());
    }
}

class ThreadSource{
    private int sum =0;

    public synchronized void add(){
        sum++;
    }
    public int getSum(){
        return sum;
    }
}