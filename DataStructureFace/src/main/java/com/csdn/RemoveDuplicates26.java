package com.csdn;


import java.util.Arrays;

/**
 * 给定一个有序的数组，将数组中重复的元素去除掉，返回去重以后的数组
 * 返回⾮重复数字的个数，并且把 nums ⾥重复的数字也去掉。
 */
public class RemoveDuplicates26 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3};
        int i = removeDuplicates2(nums);
        System.out.println(i);
    }

    /**
     * 第二种方式采用的是快慢指针的方式来解决的
     * 采用for循环
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i+1;
    }

    /**
     * 第二种方式采用的是快慢指针的方式来解决的
     * while 循环
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums) {
         int i = 0;
         int j = i+1;
         while (j < nums.length - 1){
             if (nums[j] != nums[i]){
                 nums[i++]=nums[i];
             }else {
                 j++;
             }
         }
         nums[i] = nums[j];
        System.out.println(Arrays.toString(nums));
         return i+1;
    }
    /**
     * 这个方法差不多是采用的是迭代的方式
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int len = 1;//表示没有重复的元素有多少个
        for (int i = 0; i < nums.length - 1; i++) {
            while (i < nums.length - 1){
                if (nums[i] == nums[i+1]){
                    i++;
                }else {
                    nums[len] = nums[i+1];
                    len++;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return len;
    }
}
