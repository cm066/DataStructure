package com.csdn;


import java.util.Arrays;

/**
 * ，然后将这些数字的位置重新排列，
 * 得到⼀个刚好⽐原数字⼤的⼀种排列。如果没有⽐原数字⼤的，就升序输出。
 * 就例如123 变成132   321 就变成 123
 */
public class NextPermutation31 {
    public static void main(String[] args) {
        int[] a = {1,5,8,4,7,6,5,3,1};
        nextPermutation1(a);
//        [1, 5, 8, 1, 3, 4, 6, 7, 5]
//        [1, 5, 8, 5, 1, 3, 4, 6, 7]
        System.out.println(Arrays.toString(a));
        int[] b = {7, 6, 4, 3, 1};
        reverse(b,0);
    }



    public static void nextPermutation1(int[] nums){
        int i = nums.length - 2;//为什么是减2，就是为了防止数组下标越界
        //找到从有到左不在递增的数的下标
        while (i >= 0 && nums[i+1] < nums[i]){ //这个就是后一个数要比前一个数要小才会进入循环
            i--;
        }
        if (i < 0){
            //说明没有一个数比当前这个数大，所以将数组升序排序
            reverse(nums, 0);
            return;
        }
        //否则在从右到左找到一个比这个大的数
        int j = nums.length - 1;
        while (j >=0 && nums[j] <= nums[i]){
            j--;
        }
        //将这两个数进行交换位置
        swap(nums,i,j);
        System.out.println(Arrays.toString(nums));
        //然后将i位置后面的数进行升序排序
        reverse(nums,i+1);
    }





    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
    //找到第⼀个不再递增的位置
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
    //如果到了最左边，就直接倒置输出
        if (i < 0) {
            reverse(nums, 0);
            return;
        }
    //找到刚好⼤于 nums[i]的位置
        int j = nums.length - 1;
        while (j >= 0 && nums[j] <= nums[i]) {
            j--;
        }
    //交换
        swap(nums, i, j);
    //利⽤倒置进⾏排序
        reverse(nums, i + 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
