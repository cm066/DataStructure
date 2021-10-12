package com.datastructure.arr;

/**
 * 一个数组中，找到一个数只出现了一遍的数，其他数都是出现了两遍
 */
public class FindArrOneDifferent {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        int i = findArrOneDifferent(arr);
        System.out.println(i);
    }


    /**
     * 解题思路
     * 这道题其实有很多种解法 但是时间复杂度和空间复杂都为O(1)
     *
     * @param arr
     * @return
     */
    public static int findArrOneDifferent(int[] arr) {
        int target = 0;
        for (int i = 0; i < arr.length; i++) {
            target ^= arr[i];
        }
        return target;
    }
}
