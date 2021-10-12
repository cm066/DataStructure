package com.ntencent;

/**
 * @author cm
 * @create 2021/9/23-11:13 下午
 * 对有序数组进行二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4};
        BinarySearch search = new BinarySearch();
        System.out.println(search.search(arr, 2));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 如果目标值存在返回下标，否则返回 -1
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search (int[] nums, int target) {
        // write code here
        //这样就代表着这个数肯定没有在这个数组中，所以就直接返回了；
        if (target < nums[0] || target > nums[nums.length-1]) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                while (mid > 0 && nums[mid] == nums[mid -1] ){
                    mid--;
                }
                return  mid;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
