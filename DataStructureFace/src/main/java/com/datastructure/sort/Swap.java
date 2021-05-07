package com.datastructure.sort;


import java.util.Arrays;
import java.util.Random;

/**
 * 数组中公用方法
 */
public class Swap {


    /**
     * 数组中两个数进行交换位置的方法
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void printArr(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 随机生成一个n个长度的数组
     * @param n
     * @return
     */
    public static int[] generetArr(int n){
        int[] arr = new int[n];
        Random random = new Random();
        for (int j = 0; j < n ; j++) {
            arr[j] = random.nextInt(1000000000);
        }
        return arr;
    }
}
