package com.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;


/**
 * todo 了解其原理
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {


        CountDownLatch downLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {

            int finalI = i;
            new Thread(()->{
                System.out.println("第"+ finalI +"个同学出教室");
                downLatch.countDown();
            }).start();

        }
        downLatch.await();
        System.out.println("班长出教室关灯");
    }
}
