package com.dp;

/**
 * @author cm
 * @create 2021/10/30-9:08 下午
 */
public class Tribonacci {
    public static void main(String[] args) {
        int i = DPtribonacci(4);
        System.out.println(i);
    }

    /**
     * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
     * @param n
     * @return
     */
    public static int DPtribonacci(int n) {
        if (n < 3){
            return n == 0? 0:1;
        }
        int T0 = 0;
        int T1 = 1;
        int T2 = 1;
        int T4 = 0;
        for (int i = 3; i <= n; i++) {
            T4 = T0+T1+T2;
            T0 = T1;
            T1 = T2;
            T2 = T4;
        }
        return T4;
    }
}
