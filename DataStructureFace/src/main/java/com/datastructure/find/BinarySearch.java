package com.datastructure.find;


/**
 * 二分查找，只适用于一个有序数组中
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int i = binarySearch(arr, 9);
        System.out.println(i);
    }


    /**
     * 解法一 可以遍历整个数组，然后进行比较，这样的时间复杂度为O(n）
     * 解法二 因为是一个有序的数组，所以采用二分查找的方法，相当于是每次都折半查找，只在一半的数组中查找
     * @param arr
     * @return
     */
    public static int binarySearch(int[] arr,int target){
        if (null == arr || arr.length == 0){
            return -1;
        }
        int l = 0;
        int r = arr.length -1;
        int mid = 0;
        while (l <= r){
            mid = (l + r) >> 1;
            int m = l + ((r-l) >> 1);
            if (arr[mid] == target){
                return target;
            }else if (arr[mid] > target){
                r = mid -1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }

}
