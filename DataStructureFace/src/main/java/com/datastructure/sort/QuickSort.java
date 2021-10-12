package com.datastructure.sort;


/**
 * TODO 快速排序为完成
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 8, 1, 9, 5, 4, 6, 10};
        sort(arr, 0, arr.length - 1);
        Swap.printArr(arr);
    }

    public static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) return;
        //分区
        int mid = partition(arr, leftBound, rightBound);
        sort(arr, leftBound, mid - 1);
        sort(arr, mid + 1, rightBound);
    }

    static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];//以最右边那个数作为基数
        int left = leftBound;
        int right = rightBound - 1;
        while (left <= right) {
            while (left <= right && arr[left] <= pivot) left++;

            while (left < right && arr[right] >= pivot) right--;

            if (left < right) Swap.swap(arr, left, right);
        }
        Swap.swap(arr, left, rightBound);
        return left;
    }

    static void partition1(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];//以最右边那个数作为基数
        int left = leftBound;
        int right = rightBound - 1;
        while (left < right) {
            while (left <= right && arr[left] <= pivot) left++;

            while (left < right && arr[right] >= pivot) right--;

            if (left < right) Swap.swap(arr, left, right);
        }
        Swap.swap(arr, left, rightBound);
    }

    public static void quickSort(int[] arr, int left, int right) {

    }
}
