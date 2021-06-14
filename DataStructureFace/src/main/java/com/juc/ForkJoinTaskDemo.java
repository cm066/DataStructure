package com.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;


/**
 * todo 了解其原理
 */
public class ForkJoinTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread1 myThread1 = new MyThread1(0,100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(myThread1);
        System.out.println(submit.get());
        forkJoinPool.shutdown();
    }
}

class MyThread1 extends RecursiveTask<Integer>{

    private int max = 10;
    int begin;
    int end;
    int result;

    public MyThread1(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if ((end - begin) <= 10){
            for (int i = begin; i <= end; i++) {
                result = result+i;
            }

        }else {
            int mid = begin + (end - begin)/2;
            MyThread1 myThread1 = new MyThread1(begin, mid);
            MyThread1 myThread2 = new MyThread1(mid+1,end);
            myThread1.fork();
            myThread2.fork();
            result = myThread1.join()+myThread2.join();

        }
        return result;
    }
}