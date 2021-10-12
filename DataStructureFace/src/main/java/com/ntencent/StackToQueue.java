package com.ntencent;

import java.util.Stack;

/**
 * @author cm
 * @create 2021/9/23-10:54 下午
 * 用两个栈去模拟队列
 * 栈是先进后出，队列是先进先出
 */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.push(1);
        stackToQueue.push(2);
        System.out.println(stackToQueue.pop());
        System.out.println(stackToQueue.pop());
        System.out.println(stackToQueue.pop());
    }
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        if (!stack2.isEmpty()) return stack2.pop();
        if (stack1.isEmpty()) return -1;
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
