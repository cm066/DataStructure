package com.dp;

/**
 * @author cm
 * @create 2021/11/1-10:19 下午
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rob {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    /**
     * 解题的思路，只有一家的时候只能选择一种，然而有两家的时候，选择其中最大的哪一个进行偷窃
     * 因为相邻的不能偷取，所以
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {

        /**
         * 基础条件的判断
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
       return dp[length-1];
    }
}
