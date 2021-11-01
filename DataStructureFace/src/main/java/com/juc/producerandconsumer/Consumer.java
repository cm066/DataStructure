package com.juc.producerandconsumer;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cm
 * @create 2021/10/26-11:37 下午
 */
public class Consumer implements Runnable{
    public static final int CONSUMER_GAP = 100;
    //总次数
    static final AtomicInteger TURN = new AtomicInteger(0);
    //生产者对象编号
    static final AtomicInteger CONSUMER_NO = new AtomicInteger(1);

    String name = null;
    Callable action = null;
    int gap = CONSUMER_GAP;
    public Consumer(Callable action,int gap) {
        this.action = action;
        this.gap = gap;
        name = "生产者-"+CONSUMER_NO.incrementAndGet();
    }
    @Override
    public void run() {
        while (true){
            try {
                TURN.incrementAndGet();
                Object out = action.call();
                if (null != out){
                    System.out.println("第"+TURN.get()+"轮消费"+out);
                }
                TimeUnit.MILLISECONDS.sleep(gap);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
