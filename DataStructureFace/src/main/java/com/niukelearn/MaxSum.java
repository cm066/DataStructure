package com.niukelearn;

/**
 * @author cm
 * @Time 2021/10/23-8:02 下午
 * 求数组子数组最大累加和
 */
public class MaxSum {
    public static void main(String[] args) {
        int[] arr = {1,-2,3,5,-2,6,-1};
        int i = maxSum(arr);
        System.out.println(i);
    }
    public static int max(int[][] m){
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        /**
         * -90 48 78
         * 64 -40 64
         * -81 - 7 66
         *
         * 48 78
         * -40 64
         * -7 66
         */
        int max= 0;
        
        return max;
    }

    /**
     * 这个是获取子数组的最大和
     * @param arr 愿数组
     * @return 返回子数组最大累积和
     */
    public static int maxSum(int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        int cur = 0;
        int max = 0;
        //1 -2 3 5 -2 6 -1
        for (int i = 0; i < arr.length; i++) {
            cur = cur+arr[i]>0?cur+arr[i]:0;
            max = Math.max(max,cur);
        }
        return max;
    }

    /**
     * 这个是求出最大累积和的子数组，并将子数组反回去
     * @param arr
     * @return
     */
    public static int[] getMaxSumArr(int[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        int[] result = new int[arr.length];
        int cur = 0;
        int max = 0;
        //1 -2 3 5 -2 6 -1
        // 2-5
        for (int i = 0; i < arr.length; i++) {

        }
        int index = 0;
        return result;
    }
}
