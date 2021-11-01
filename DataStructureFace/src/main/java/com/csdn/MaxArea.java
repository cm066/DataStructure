package com.csdn;


/**
 * 每个数组代表⼀个⾼度，选两个任意的柱⼦往⾥边倒⽔，能最多倒多少⽔。
 * @author wxr
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea1(height);
        System.out.println(i);
    }

    /**
     * 第一种解法，采用暴力遍历来解决，遍历出任意两根柱子之间能装的水
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[j], height[i]);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    /**
     * 采用双指针，然后两边往中间移动，那个大就往那边移动
     *
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * (height[left] <= height[right] ? height[left++] : height[right--]));
        }
        return maxArea;
    }
}
