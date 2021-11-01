package com.dp;

/**
 * @author cm
 * @create 2021/11/1-9:36 下午
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int i = climbStairs(3);
        System.out.println(i);
    }

    /**
     *采用动态规划的方法来解决
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int a = 0;
        int b = 0;
        int c = 1;
        for (int i = 1; i <= n; i++) {
            a = b;
            b = c;
            c = a+b;
        }
        return c;
    }
    /**
     * 第一种采用递归的方式
     * @param n 这是有几步楼梯
     * @return 返回方法树
     */
    public static int climbStairs1(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return climbStairs1(n-2)+climbStairs1(n-1);
    }
}
