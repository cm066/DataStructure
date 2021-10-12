package com.ntencent;

import java.util.HashMap;

/**
 * @author cm
 * @create 2021/9/26-2:00 下午
 * 最长子数组
 */
public class MaxLength {

    public int maxLength (int[] arr) {
        // write code here
        if (arr.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < arr.length; ++i) {
            if (map.containsKey(arr[i])) {
                j = Math.max(j, map.get(arr[i]) + 1);
            }
            map.put(arr[i], i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxLength maxLength = new MaxLength();
        int[] arr = {1,2,2,3,2,1};
        int i = maxLength.maxLength(arr);
        System.out.println(i);
    }
}
