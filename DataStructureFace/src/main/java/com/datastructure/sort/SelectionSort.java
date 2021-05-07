package com.datastructure.sort;


import java.util.Arrays;

/**
 * 选择排序（Selection sort）是一种简单直观的排序算法。
 * 它的工作原理是：第一次从待排序的数据元素中选出最小（或最大）的一个元素，
 * 存放在序列的起始位置，然后再从剩余的未排序元素中寻找到最小（大）元素，
 * 然后放到已排序的序列的末尾。以此类推，直到全部待排序的数据元素的个数为零。选择排序是不稳定的排序方法。
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {1,4,6,7,3,8,2,9};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 解题思路
     *  1、每次都拿未排序的数组中的第一个数作为基准然后找到最小的数，然后放到排好序数组的末尾
     *  时间复杂度为O(n)的平方
     * @param arr
     */
    public static void selectionSort(int[] arr){
        if (null == arr || arr.length <2){
            return;
        }
        //外层for循环是控制在那个访问内做这件事
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            //这个循环就是找出这个范围内的最小值的下标
            for (int j = i+1; j < arr.length ; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            //其实可以可以优化，若minIndex没有变化，就不用进行交互
            Swap.swap(arr,i,minIndex);
        }
    }


}
