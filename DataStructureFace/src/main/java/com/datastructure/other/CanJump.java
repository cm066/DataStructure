package com.datastructure.other;

/**
 * 贪心算法解决跳跃问题
 */
public class CanJump {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(canJump(arr));
    }

    public static boolean canJump(int[] nums) {

        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
            }
            if (rightmost >= n - 1) {
                return true;
            }
        }
        return false;
    }
}
