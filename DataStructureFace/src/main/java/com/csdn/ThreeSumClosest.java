package com.csdn;


import java.util.Arrays;

/**
 * 给定一个数组然后给定一个目标数，找出三个数的和最接近这个目标数的三个数的和
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int i = threeSumClosest1(nums, 1);
        System.out.println(i);
    }

    public static int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int sub=Integer.MAX_VALUE;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            int lo = i+1,hi = nums.length - 1;
            while (lo < hi ){
                if (Math.abs((nums[lo]+nums[hi]+nums[i]-target))<sub){
                    sum = nums[lo] + nums[hi] + nums[i];
                    sub = Math.abs(sum-target);
                }
                if(nums[lo]+nums[hi]+nums[i]>target){
                    hi--;
                }else{
                    lo++;
                }
            }
        }
        return sum;
    }
    /**
     * 第一种解法，还是采用暴力递归的方法来，穷举出任何情况
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int sum = target - (nums[i] + nums[j] + nums[k]);
                    if(i == 0){
                        res = sum;
                    }else {
                        res = Math.min(res,sum);
                    }

                }
            }
        }
        return res;
    }
}
