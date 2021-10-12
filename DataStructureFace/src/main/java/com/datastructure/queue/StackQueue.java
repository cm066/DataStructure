package com.datastructure.queue;


import java.util.Stack;

/**
 * 怎么用栈实现队列
 */
public class StackQueue {
    public static void main(String[] args) {
        SQueue sQueue = new SQueue();
        sQueue.push(1);
        sQueue.push(2);
        Integer pop = sQueue.pop();
        System.out.println(pop);
        sQueue.push(3);
        System.out.println(sQueue.pop());
    }
}

class SQueue {
    Stack<Integer> data;
    Stack<Integer> help;

    public SQueue() {
        data = new Stack<>();
        help = new Stack<>();
    }

    public void push(Integer a) {
        data.push(a);
    }

    public Integer pop() {
        if (data.size() == 1) {
            return data.pop();
        }
        while (data.size() > 1) {
            help.push(data.pop());
        }
        int ins = data.pop();
        swap();
        ;
        return ins;
    }

    public void swap() {
        Stack<Integer> tmp = data;
        data = help;
        help = tmp;
    }
}