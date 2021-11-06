package com.dp;

/**
 * @author cm
 * @create 2021/11/5-11:31 下午
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {4,-1,2,1};
        int i = maxSubArray(nums);
        System.out.println(i);
    }
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int cur = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i],nums[i]+ cur);
            max = Math.max(max,cur);
        }
        return max;
    }
}
