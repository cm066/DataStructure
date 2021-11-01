package com.ntencent;

import java.util.Arrays;

/**
 * @author cm
 * @create 2021/10/13-9:07 下午
 * 数组中只出现一次的数（其它数出现k次）
 */
public class FoundOnceNumber {
    public static void main(String[] args) {
        int[] arr = {5,4,1,1,5,1,5};
        int i = foundOnceNumber1(arr, 3);
        System.out.println(i);

        System.out.println("------------------");
        int[] num = {2,2,1};
        int i1 = foundOnceNumber1(num, 2);
        System.out.println(i1);

        int[] arr1 = {0,0,-119,0,0,-119,99,-132,-119,-119,-119,0,-132,-132,-132,-132};
        int i2 = foundOnceNumber1(arr1, 5);
        System.out.println(i2);
    }

    /**
     * 输入：
     * [5,4,1,1,5,1,5],3
     * 复制
     * 返回值：
     * 4
     */
    public static int foundOnceNumber (int[] arr, int k) {
        //可以先进行排序，然后找
        Arrays.sort(arr);
        int res = arr[0];
        int index = 1;
        for (int i = 0; i < arr.length;) {
            while (index <= k){
                if (arr[i] == res){
                    i++;
                    index++;
                }else {
                    return res;
                }
            }
            if (i == arr.length-1){

                return arr[i];
            }else {
                index = 1;
                res = arr[i];
            }

        }
        return res;
    }


    public static int foundOnceNumber1 (int[] arr, int k) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i+1]){
                i += k-1;
            }else {
                return arr[i];
            }
        }
        return arr[arr.length-1];
    }
}
