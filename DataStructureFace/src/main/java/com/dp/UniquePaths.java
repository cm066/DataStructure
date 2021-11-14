package com.dp;

/**
 * @author cm
 * @create 2021/11/14-8:31 下午
 */
public class UniquePaths {
    public static void main(String[] args) {
        int i = uniquePaths(3, 7);
        System.out.println(i);
    }

    /**
     *  因为当前的位置取决于上一个和左一个
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //因为只能往右和往下，所以第一行和第一列的值都是1
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
