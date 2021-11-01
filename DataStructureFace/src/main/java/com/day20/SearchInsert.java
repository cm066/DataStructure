package com.day20;

/**
 * @author cm
 * @create 2021/10/30-9:57 下午
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int i = searchInsert(nums, 5);
        System.out.println(i);
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || target <= nums[0]){
            return 0;
        }
        if (target > nums[nums.length-1]){
            return nums.length;
        }
        int L = 0;
        int R = nums.length-1;
        while (L <= R){
            int mid = L + (R-L)/2;
            if (target == nums[mid]){
                return mid;
            }else if (target < nums[mid]){
                R = mid-1;
            }else {
                L = mid+1;
            }
        }
        return R+1;
    }
}
