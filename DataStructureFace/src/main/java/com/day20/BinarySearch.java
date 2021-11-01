package com.day20;

/**
 * @author cm
 * @create 2021/10/30-9:30 下午
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int search = search(nums, 9);
        System.out.println(search);
    }

    /**
     *  nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * @param nums 输入的数组
     * @param target 目标数据
     * @return 返回值
     */
    public static int search(int[] nums, int target) {
        //先边界值的处理
        if (nums == null || nums.length == 0 || (target < nums[0]) || (target > nums[nums.length-1])){
            return -1;
        }
        int L = 0;
        int R = nums.length -1;
        while (L < R){
            int mid = L +(R - L)/2;
            if (target == nums[mid]){
                return mid;
            }else if (target < nums[mid]){
                R = mid-1;
            }else {
               L = mid+1;
            }
        }
        return -1;
    }
}
