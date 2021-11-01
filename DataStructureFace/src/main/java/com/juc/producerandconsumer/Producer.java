package com.juc.producerandconsumer;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cm
 * @create 2021/10/26-11:28 下午
 */
public class Producer implements Runnable{

    //生产时间间隔
    public final static int PRODUCE_GAP = 10;
    //总次数
    static final AtomicInteger TURN = new AtomicInteger(0);
    //生产者对象编号
    static final AtomicInteger PRODUCE_NO = new AtomicInteger(1);
    String name = null;
    Callable  action = null;
    int gap = PRODUCE_GAP;
    public Producer(Callable action,int gap) {
        this.action = action;
        this.gap = gap;
        name = "生产者-"+PRODUCE_NO.incrementAndGet();
    }

    @Override
    public void run() {
        while (true){
            try {
                Object out = action.call();
                if (null != out){
                    System.out.println("第"+TURN.get()+"轮生产"+out);
                }
                TimeUnit.MILLISECONDS.sleep(gap);
                TURN.incrementAndGet();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
