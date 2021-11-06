package com.dp;

/**
 * @author cm
 * @create 2021/11/5-11:04 下午
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanJump {

    public static void main(String[] args) {

    }
    public boolean canJump(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightMost){
                //其实这一步就体现了贪心，假设每一步都走最多的
                //但是这个还有没有最优解呢，假设每一步的最大一步加上最大一步到达的位置，看是否能到底最后呢 todo
                rightMost = Math.max(rightMost,i+nums[i]);
            }
            if (rightMost >= nums.length-1){
                return true;
            }
        }
        return false;
    }
    }
