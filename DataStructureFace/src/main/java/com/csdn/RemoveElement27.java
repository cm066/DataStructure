package com.csdn;


import java.util.Arrays;

/**
 * 给定一个数组，然后一个值，将数组中的该值去除掉
 */
public class RemoveElement27 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,2};
        int i = removeElement1(nums, 3);
        System.out.println(i);
    }


    /**
     *  题目还有一个提示就是可以随意交换数组中的元素
     *  上一个解法采用的不相等的时候移除掉，
     *  现在这种方法采用的是相同的时候跟不相同的元素位置相交换
     *  todo
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return n;
//        int fast = 0;
//        int slow = 0;
//        while (fast < nums.length){
//            while (nums[fast] == val && nums[fast+1] != val){
//               slow++;
//               fast++;
//            }
//            nums[slow++] = nums[fast++];
//            fast++;
//        }
//        System.out.println(Arrays.toString(nums));
//        return slow+1;
    }
    /**
     * 第一种做法也是采用26题的快慢指针的思想
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length){
            if (nums[fast] == val){
                fast++;
            }else {
                nums[slow++] = nums[fast++];
            }
        }
        System.out.println(Arrays.toString(nums));
        return slow + 1;
    }
}
