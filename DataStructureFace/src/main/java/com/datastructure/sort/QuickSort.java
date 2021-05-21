package com.datastructure.sort;


/**
 * TODO 快速排序为完成
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7,3,2,8,1,6,5,4,9};
        sort(arr,0,arr.length-1);
    }

    public static void sort(int[] arr,int leftBound,int rightBound){
        //分区
        partition(arr, leftBound, rightBound);
    }
    static void partition(int[] arr,int leftBound,int rightBound){
        int pivot = arr[rightBound];//以最右边那个数作为基数
        int left = leftBound;
        int right = rightBound-1;
        while (left < right){
            while (arr[left] <= pivot) left++;
            
            while (arr[right] >= pivot) right--;

            if (left < right) Swap.swap(arr,left,right);
        }
    }
    public static void quickSort(int[] arr,int left,int right){

    }
}
