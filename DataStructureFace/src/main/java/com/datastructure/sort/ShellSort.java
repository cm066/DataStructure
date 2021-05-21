package com.datastructure.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
//        int[] arr = {2,5,7,1,4,3,8,9};
//        int[] arr = {9,2,5,7,1,3};
        int[] arr = Swap.generetArr(100);
        shellSort(arr);
        Swap.printArr(arr);
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        Arrays.sort(nums);
        Swap.printArr(nums);
    }

    public static void shellSort(int[] arr){

        int N = arr.length;
        for (int gap = N /2;gap >0;gap /= 2){
            for (int i = gap; i < N; i++) {
                int j = i;
                while (j - gap >= 0&& arr[j] <arr[j-gap]){
                    Swap.swap(arr,j,j-gap);
                    j -= gap;
                }
            }
        }
    }
}
