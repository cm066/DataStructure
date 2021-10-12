package com.datastructure.sort;


/**
 * 计数排序，适合量大范围小的
 * 腾讯面试题 如果知道你在高考中的名次
 */
public class CountSort {

    public static void main(String[] args) {
//        int[] arr = {0,2,3,5,6,7,8,9,4,0,2,4,0,0,1,1};
        int[] arr = {0, 1, 2, 0, 0, 1};
        int[] ints = countSort1(arr);
        Swap.printArr(ints);
    }

    /**
     * 稳定版本的计数排序
     *
     * @param arr
     * @return
     */
    public static int[] countSort1(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[10];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            result[--count[arr[i]]] = arr[i];
        }
        return result;
    }


    /**
     * 这个是不稳定的，所谓的稳定与不稳定，就是相同的数在排序后，他们的位置不变
     *
     * @param arr
     * @return
     */
    public static int[] countSort(int[] arr) {
        //要分配一个新的数组用来放排好的数组
        int[] result = new int[arr.length];
        int[] count = new int[10];//表示范围的数组
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 0, j = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                result[j++] = i;
            }
        }
        return result;
    }
}
