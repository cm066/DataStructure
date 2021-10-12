package com.ntencent;

import java.util.Arrays;

/**
 * @author cm
 * @create 2021/9/13-9:35 下午
 *
 * 腾讯牛课网 给定一个数组进行排序
 */
public class MySort {
    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};//,1,4
//        dubboSort(arr);
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    //从最简单的冒泡排序算法开始 时间复杂度为O(N平方）
    public static void dubboSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    int tem = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tem;
                }
            }
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr, int leftBound, int rightBound){
        if (leftBound >= rightBound) return;
        int mid = partition(arr, leftBound, rightBound);
        quickSort(arr,leftBound,mid-1);
        quickSort(arr,mid+1,rightBound);
    }

    static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];//以最右边那个数作为基数
        int left = leftBound;
        int right = rightBound - 1;
        while (left <= right){
            while (left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] >= pivot) right--;
            if (left < right){
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        int tmp = arr[left];
        arr[left] = arr[rightBound];
        arr[rightBound] = tmp;
        return left;
    }
}
