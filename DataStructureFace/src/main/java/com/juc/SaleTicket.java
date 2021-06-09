package com.juc;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket{//资源类
    private Integer number = 30;
    private final Lock lock = new ReentrantLock();

    public  void saleTicket(){
        lock.lock();
        try {
            if (number > 0){
            System.out.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"\t还剩下"+number);
             }
        }finally {
            lock.unlock();
        }
    }
//    //暴露方法
//    public synchronized void saleTicket(){
//
//        if (number > 0){
//            //Thread.currentThread().getName();常用的代码抽取模板，直接用快捷键即可
//            System.out.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"\t还剩下"+number);
//        }
//    }
}

/**
 * 题目 三个售票员 卖出 30张票
 *
 * 多线程编程的企业级套路+模板
 *
 * 1 在高内聚低耦合的前提夏，多线程      操作(对外暴露的调用的方法)      资源类
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        },"C").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i < 40; i++) {
//                    ticket.saleTicket();
//                }
//            }
//        },"A").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i < 40; i++) {
//                    ticket.saleTicket();
//                }
//            }
//        },"B").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i < 40; i++) {
//                    ticket.saleTicket();
//                }
//            }
//        },"C").start();
    }
}
