package com.datastructure.other;


/**
 * TODO
 * 给定一个二维数组，然后给定一个数，最快从这个二维数组中找到这个数。
 * 二维数组从左到右，从上到下是递增的有序的
 */
public class FindMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 5, 6},
                {2, 5, 7, 9},
                {4, 6, 8, 10}};
        boolean b = findMatrix(arr, 50);
        System.out.println(b);
    }

    /**
     * 给定一个二维数组，然后给定一个数，最快从这个二维数组中找到这个数。
     * 二维数组从左到右，从上到下是递增的有序的
     *
     * @param arr
     * @param target
     */
    public static boolean findMatrix(int[][] arr, int target) {

        //基础条件就不判断了，只写核心代码
//        boolean flag = false;
        int row = 0;
        int col = arr[0].length - 1;
        while (row <= arr.length - 1 && col >= 0) {
            if (arr[row][col] == target) {
                return true;
            } else if (target < arr[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
