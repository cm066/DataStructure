package com.datastructure.stack;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 如何仅用队列实现栈
 * 他们两个的特点刚刚相反，队列是先进先出，而栈是先进后出
 */
public class OtherStack {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        QStack qStack = new QStack();
        qStack.push(1);
        qStack.push(2);
        System.out.println(qStack.pop());
    }
}

class QStack {
    Queue<Integer> data;
    Queue<Integer> help;

    public QStack() {
        data = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(Integer a) {
        data.add(a);
    }

    public Integer pop() {
        while (data.size() != 1) {
            help.add(data.poll());
        }
        int tem = data.poll();
        //然后把help的还原回去
        while (!help.isEmpty()) {
            data.add(help.poll());
        }
        return tem;
    }
}
