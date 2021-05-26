package com.datastructure.stack;


import com.sun.xml.internal.bind.v2.TODO;

import java.util.Stack;

/**
 * TODO 实现一个特殊的栈，在实现栈的基本功能的基础上，在实现返回栈中最小元素的操作，pop,push,getMin的时间复杂度都是0（1）
 */
public class StackMain {
    public static void main(String[] args) {
        OStack oStack = new OStack();
        oStack.push(3);
        oStack.push(5);
        Integer min = oStack.getMin();
        System.out.println(min);
    }
}
/**
 * TODO 实现一个特殊的栈，在实现栈的基本功能的基础上，在实现返回栈中最小元素的操作，pop,push,getMin的时间复杂度都是0（1）
 * 实现的思路，采用两个栈来实现，利用一个栈来装当前最小数，放进去一个数的时候和最小栈里面数进行比较，如果小于就放进那个最小栈，反之就把最小栈取出来的数在压栈一次
 */
class OStack{

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(Integer a){
        stack.push(a);
        if (minStack.size() == 0){
            minStack.push(a);
        }else {
            int tmp = minStack.pop();
            tmp = a > tmp ? tmp : a;
            minStack.push(tmp);
        }
    }
    public Integer pop(){
        Integer pop = stack.pop();
        return pop;
    }
    public Integer getMin(){
        return minStack.pop();
    }
}