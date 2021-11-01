package com.niukelearn;

/**
 * @author cm
 * @create 2021/10/16-9:42 上午
 *贪心有关的算法
 */
public class Greed {
    public static void main(String[] args) {
        int[] arr = {3,1,2,5,2,4};
        long water = getWater(arr);
        System.out.println(water);
    }

    /**
     * 贪心问题解决路灯问题
     * @param road
     * @return
     */
    public static int minLight(String road){
        char[] str = road.toCharArray();
        int index = 0;
        int light = 0;
        while (index < str.length){
            if (str[index] == 'X'){
                index++;
            }else {
                light++;
                if (str[index+1] == 'X'){
                    index = index+2;
                }else {
                    index = index+3;
                }
            }
        }
        return light;
    }
    public static long getWater(int[] arr){

        if (arr == null || arr.length < 3) {
            return 0;
        }
        long value = 0;
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];
        int l = 1;
        int r = arr.length - 2;
        while (l <= r){
            if (leftMax <= rightMax) {
                value += (long)Math.max(0, leftMax - arr[l]);
                leftMax = Math.max(leftMax, arr[l++]);
            } else {
                value += (long)Math.max(0, rightMax - arr[r]);
                rightMax = Math.max(rightMax, arr[r--]);
            }
        }
        return value;
    }
    /**
     * 给定一个数组，然后求出任意两个柱子直接能装最多水的
     * 现在采用的是双指针的办法，还有暴力，还有贪心
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {
        int  max =0 ;
        int left = 0;
        int right = height.length-1;
        while (left < right){
            max = Math.max(max,(right -left)*(height[left]>= height[right]?height[right--] : height[left++]));
        }
        return max;
    }
    /**
     * 贪心问题解决打包问题
     * @param arr
     * @return
     */
    public static int minOps(int[] arr){

        if (arr == null || arr.length == 0){
            return -1;
        }
        int size = arr.length;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % size != 0){
            return -1;
        }
        int avg = sum/size;
        int leftSum = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            leftSum = leftSum - i*avg;
            int rightSum = (sum - leftSum-arr[i]) - (sum - i - 1)*avg;
            if (leftSum < 0 && rightSum < 0){
                ans  = Math.max(ans,Math.abs(leftSum)+Math.abs(rightSum));
            }else {
                ans = Math.max(ans,Math.max(Math.abs(leftSum),Math.abs(rightSum)));
            }
            leftSum += arr[i];
        }
        return ans;
    }
}
