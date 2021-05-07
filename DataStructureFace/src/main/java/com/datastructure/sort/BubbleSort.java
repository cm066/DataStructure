package com.datastructure.sort;


/**
 * 它重复地走访过要排序的元素列，依次比较两个相邻的元素，
 * 如果顺序（如从大到小、首字母从Z到A）错误就把他们交换过来。
 * 走访元素的工作是重复地进行直到没有相邻元素需要交换，也就是说该元素列已经排序完成。
 */
public class BubbleSort {

    public static void main(String[] args) {

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
}
