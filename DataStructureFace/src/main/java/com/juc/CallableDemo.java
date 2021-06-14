package com.juc;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.FutureTask;

/**
 *
 */
public class CallableDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 1;
    }
}