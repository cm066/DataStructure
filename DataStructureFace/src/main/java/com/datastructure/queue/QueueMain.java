package com.datastructure.queue;


/**
 * 使用数组实现队列
 */
public class QueueMain {
    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.print();
        Integer integer = queue.get();
        System.out.println(integer);
        queue.add(4);
        queue.print();
    }
}

class Queue {
    private Integer[] arr;
    private Integer start;
    private Integer end;
    private Integer size;

    public Queue(Integer initSize) {
        arr = new Integer[initSize];
        start = end = size = 0;
    }

    public void add(Integer a) {
        if (size == arr.length) {
            System.out.println("队列已经满了，没有空位置了");
            return;
        }
        size++;
        arr[end] = a;
        end = end == arr.length - 1 ? 0 : end + 1;
    }

    public Integer get() {
        if (size == 0) {
            System.out.println("队列里面没有元素了。。。没有办法给你了");
            throw new ArrayIndexOutOfBoundsException("队列空了");
        }
        size--;
        int temp = start;
        start = start == arr.length - 1 ? 0 : start + 1;
        return arr[temp];
    }

    public void print() {
        for (Integer integer : arr) {
            System.out.println(integer);
        }
    }
}