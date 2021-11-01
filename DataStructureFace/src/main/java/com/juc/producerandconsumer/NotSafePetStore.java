package com.juc.producerandconsumer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cm
 * @create 2021/10/26-11:47 下午
 */
public class NotSafePetStore {
    private static NoSafeDateBuffer<IGoods> noSafeDateBuffer = new NoSafeDateBuffer<>();

    static Callable<IGoods> producceAction= ()->{
        IGoods goods = IGoods.produceOne();
        try {
            noSafeDateBuffer.add(goods);
        }catch (Exception e){
            e.printStackTrace();
        }
        return goods;
    };
    static Callable<IGoods> consumerAction= ()->{
        IGoods fetch = null;
        try {
           fetch  = noSafeDateBuffer.fetch();
        }catch (Exception e){
            e.printStackTrace();
        }
        return fetch;
    };

    public static void main(String[] args) {
        final int THREAD_TOTAL = 10;
        ExecutorService executorService =
                Executors.newFixedThreadPool(THREAD_TOTAL);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Producer(producceAction,500));
            executorService.submit(new Consumer(consumerAction,1500));
        }
    }
}
