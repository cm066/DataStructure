package com.juc.producerandconsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cm
 * @create 2021/10/24-11:49 下午
 */
class NoSafeDateBuffer<T>{
    public static final int MAX_AMOUNT = 10;
    private List<T> dataList = new LinkedList<>();
    private AtomicInteger amount = new AtomicInteger();

    public void add(T element) throws Exception {
        if (amount.get() > MAX_AMOUNT){
            System.out.println("队列已经满了");
            return;
        }
        dataList.add(element);
        System.out.println(element);
        amount.incrementAndGet();
        if (amount.get() != dataList.size()) {
            throw new Exception("出现了数据不一致了"+amount.get()+":"+dataList.size());
        }
    }

    public T fetch() throws Exception {
        if (amount.get() < 0){
            System.out.println("队列空了");
            return null;
        }
        T t = dataList.remove(0);
        System.out.println(t);
        amount.decrementAndGet();
        if (amount.get() != dataList.size()) {
            throw new Exception("出现了数据不一致了"+amount.get()+":"+dataList.size());
        }
        return t;
    }
}