package com.datastructure.sort;


/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
       int[] arr = {1,4,6,7,3,8,2,9};
       insertionSort(arr);
       Swap.printArr(arr);
       int[] ints = Swap.generetArr(100000);
       insertionSort(ints);
       Swap.printArr(ints);
    }

    /**
     * @param arr
     */
    public static void insertionSort(int[] arr){
        //进行基础的判断
        if (null == arr || arr.length <2){
            return;
        }
        //这里i为什么是从零开始的，加入是从零开始自己和自己本身怎么比较
        for (int i = 1; i < arr.length; i++) { //这个循环是控制在那个范围内进行比较和交互

            for (int j = i-1; j > 0 && arr[j]>arr[j+1]; j--) {
                //能进这里说明，当前的前一个数比当前数大，所以要进行交互位置
                Swap.swap(arr,j,j+1);
            }
        }

    }
}
