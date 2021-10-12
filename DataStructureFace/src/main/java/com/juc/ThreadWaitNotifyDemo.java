package com.juc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//import java.util.concurrent.locks.ReentrantLock;

class AirCondition {

    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            //判断 如果采用if会出现虚假唤醒，那是因为if可能多个线程进入if了，然后
            while (number != 0) {
                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //通知
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void decrement() throws InterruptedException {

        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }
//    public synchronized void increment() throws InterruptedException {
//
//        //判断 如果采用if会出现虚假唤醒，那是因为if可能多个线程进入if了，然后
//        while (number != 0){
//            this.wait();
//        }
//        //干活
//        number++;
//        System.out.println(Thread.currentThread().getName()+"\t"+number);
//        //通知
//        this.notifyAll();
//    }
//    public synchronized void decrement() throws InterruptedException {
//
//       while (number == 0){
//            this.wait();
//        }
//        number--;
//        System.out.println(Thread.currentThread().getName()+"\t"+number);
//        this.notifyAll();
//    }
//    public synchronized void increment() throws InterruptedException {
//
//        //判断
//        if (number != 0){
//            this.wait();
//        }
//        //干活
//        number++;
//        System.out.println(Thread.currentThread().getName()+"\t"+number);
//        //通知
//        this.notifyAll();
//    }
//    public synchronized void decrement() throws InterruptedException {
//
//        if (number == 0){
//            this.wait();
//        }
//        number--;
//        System.out.println(Thread.currentThread().getName()+"\t"+number);
//        this.notifyAll();
//    }
}

/***
 * 题目： 现在有两个线程，可以操作初始值为零的一个变量，
 * 实现一个在线对变量加1，一个线程对该变量减1
 * 实现交替，来10轮，变量初始值为零
 *
 * 1 判断/干活/通知
 * 2 多线程交互中，必须要防止多线程虚假唤醒
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirCondition airCondition = new AirCondition();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}
