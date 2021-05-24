package com.datastructure.other;


import com.datastructure.sort.Swap;

import java.util.Enumeration;

/**
 * 快速排序，小于的放右边，等于的放中间，大于的放左边
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        quickSort(arr,0,arr.length-1);
//        Swap.printArr(arr);
    }
    public static void quickSort(int[] arr,int L,int R){
//        if (L < R){
            int[] partion = partion(arr, L, R);
            Swap.printArr(partion);
//            quickSort(arr,L,partion[0]-1);
//            quickSort(arr,partion[1]+1,R );
//        }

    }

    public static int[] partion(int[] arr,int L,int R){
        int less = L -1;
        int more = R;
        while (L < R){
            if (arr[L] < arr[R]){
                Swap.swap(arr,++less,L++);
            } else if (arr[L] > arr[R]) {
                Swap.swap(arr,--more,L);
            }else {
                L++;
            }
        }
        Swap.swap(arr,more,R);
        return new int[]{less+1,more};
    }

}
