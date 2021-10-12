package com.datastructure.arr;


/**
 * 找出一个数组中有两个数只出现一遍的数
 */
public class FindArrTwoDifferent {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4};
        findArrTwoDifferent(arr);
    }

    public static void findArrTwoDifferent(int[] arr) {
        int aim = 0;
        for (int i = 0; i < arr.length; i++) {
            aim ^= arr[i];
        }
        //然后找出右边第一个出现1的数
        int one = aim & (~aim + 1);
        //在遍历一边数组，然后在疑惑一遍，利用one，相当于是在新增一个相同给数进去，然后找出另外一个不相同的数
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & one) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + "************" + (aim ^ onlyOne));
    }
}
