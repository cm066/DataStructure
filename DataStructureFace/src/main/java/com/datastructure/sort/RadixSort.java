package com.datastructure.sort;


import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {421,240,115,532,999,111};
        int[] radixSort = radixSort(arr);
        Swap.printArr(radixSort);
    }
    public static int[] radixSort(int[] arr){
        int[] result = new int[arr.length];
        int[] count  = new int[10];
        //先找要找大哪一位数，看有几位,这里默认就是三位数
        for (int i = 0; i < 3; i++) {
            //先找个位数上大
            int provide = (int)Math.pow(10,i);//这个就是10的i次方
            for (int j = 0; j < arr.length; j++) {
                int num = arr[j]/provide % 10;
                count[num]++;
            }
            for (int j = 1; j < count.length; j++) {
                count[j] = count[j] + count[j-1];
            }
            for (int j = arr.length-1; j >= 0; j--) {
                int num = arr[j]/provide % 10;
                result[--count[num]] = arr[j];
            }
            //把桶里的数组有放回去
            System.arraycopy(result,0,arr,0,arr.length);
            Arrays.fill(count,0);//这个是把统计数组全部恢复为0
        }
        return result;
    }
}
