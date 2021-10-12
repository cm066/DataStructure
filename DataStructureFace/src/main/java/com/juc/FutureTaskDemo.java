package com.juc;

import java.util.concurrent.*;

/**
 * @author cm
 * @create 2021/9/28-11:59 下午
 */
public class FutureTaskDemo {
    static class ReturnableTask implements Callable<Long>{
        @Override
        public Long call() throws Exception {
            long start = System.currentTimeMillis();
            int j = 1;
            for (int i = 1; i < 1000000; i++) {
                j = j * i;
            }
            long end = System.currentTimeMillis();
            long res = end - start;
            System.out.println("callable线程启动来，可以获取返回值");
            return res;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ReturnableTask returnableTask = new ReturnableTask();
        FutureTask<Long> task = new FutureTask<Long>(returnableTask);
        Thread thread = new Thread(task);
        thread.start();
        Long aLong = task.get();//这里有可能是阻塞的也有可能不是阻塞的，这要看结果是不是赋值给了outcome
        System.out.println(aLong);
        System.out.println("main线程执行完了");

        ExecutorService service = Executors.newCachedThreadPool();
        Future<Long> submit = service.submit(returnableTask);
        Long aLong1 = submit.get();
    }
}
