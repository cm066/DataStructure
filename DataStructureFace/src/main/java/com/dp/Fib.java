package com.dp;

/**
 * @author cm
 * @create 2021/10/30-8:12 下午
 */
public class Fib {
    public static void main(String[] args) {
        int fib = fib(3);
        System.out.println(fib);
    }

    /**
     * 采用动态规划的算法
     * @param n
     * @return
     */
    public static int dpFib(int n) {
        int a = 0;
        int b= 0;
        int c = 1;
        for (int i = 2; i <= n; i++) {
            a = b;
            b = c;
            c = a+b;
        }
        return c;
    }
    /**
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * @param n 输入的数字
     * @return 返回的值
     * 第一种采用递归的方法
     */
    public static int fib(int n) {
        if (n == 0){
            return 0;
        }else if (n == 1){
            return 1;
        }else {
            return fib(n-1)+fib(n-2);
        }
    }
}
