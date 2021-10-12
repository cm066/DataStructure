package com.datastructure.other;


import java.util.Arrays;

/**
 * 用动态规划的思想解决换零钱的问题
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int i = coinChange(coins, 11);
        System.out.println(i);
    }

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
