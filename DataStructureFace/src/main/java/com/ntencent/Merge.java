package com.ntencent;

import java.util.Arrays;

/**
 * @author cm
 * @create 2021/9/27-11:43 下午
 * 合并两个有序的数组
 */
public class Merge {
    public void merge(int A[], int m, int B[], int n) {
        int i = m-1;
        int j = n-1;
        int index = m + n -1;
        while (i >= 0 && j >= 0){
            A[index--] = A[i] > B[j]?A[i--]:B[j--];
        }
        while (j >= 0){
            A[index--] = B[j--];
        }
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] arr = {3,4,5,6,0,0};
        int[]  arr1 = {1,2};
        merge.merge(arr,4,arr1,2);
        System.out.println(Arrays.toString(arr));
    }
}
