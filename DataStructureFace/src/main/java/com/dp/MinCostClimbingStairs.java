package com.dp;

/**
 * @author cm
 * @create 2021/11/1-9:49 下午
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 *
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {

    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0]=dp[1]=0;
        //因为最大只能走两部，所以先到第2步，然后在根据是走一步还是两步的选择
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(cost[i-1]+dp[i-1],cost[i-2]+dp[i-2]);
        }
        System.out.println(dp);
        return dp[n];
    }
}
