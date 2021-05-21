package com.datastructure.sort;


import java.util.Arrays;

/**
 * 它重复地走访过要排序的元素列，依次比较两个相邻的元素，
 * 如果顺序（如从大到小、首字母从Z到A）错误就把他们交换过来。
 * 走访元素的工作是重复地进行直到没有相邻元素需要交换，也就是说该元素列已经排序完成。
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = Swap.generetArr(100);
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
//        bubbleSort1(arr);
//        selectSort(arr);
        Arrays.sort(copy);
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(copy));
    }

    /**
     * 解题思路：
     *  1、从未排序的数组中进行比较相邻两个数的交互
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        //进行基础的判断
        if (null == arr || arr.length <2){
            return;
        }
        //外层for循环就是控制在那个范围内进行交互，即为把以排好序的数去除
        for (int i = arr.length -1; i >0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]){
                    Swap.swap(arr,j,j+1);
                }
            }
        }
    }

    public static void bubbleSort1(int[] arr){
        //进行基础的判断
        if (null == arr || arr.length <2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j-1] > arr[j]){
                    Swap.swap(arr,j-1,j);
                }
            }
        }
    }

    public static void selectSort(int[] arr){
        //进行基础的判断
        if (null == arr || arr.length <2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            //每次都找最小的数
            for (int j = i+1; j < arr.length; j++) {
                min = arr[min] > arr[j] ? j : min;
            }
            if (min == i){
                continue;
            }else {
                Swap.swap(arr,i,min);
            }
        }
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[i];
            while (j > 0 && temp<arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
