package com.niukewang.order;

import java.util.Random;

/**
 * @author cm
 * @create 2021/9/29-10:45 下午
 */
public class Test {
    public static void main(String[] args) {

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int R = random.nextInt(10) +1;
            double random1 = Math.random();
            System.out.println(random1);
            System.out.println(R);
        }

    }
}
