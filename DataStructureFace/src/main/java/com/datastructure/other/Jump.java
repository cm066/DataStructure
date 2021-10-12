package com.datastructure.other;

/**
 * 用贪心算法解决跳跃问题2，跳跃问题1是不管你跳跃的次数，只要你能达到最后即可
 * 然而跳跃表2是要用最少的步骤解决
 */
public class Jump {

    public static void main(String[] args) {

    }

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
