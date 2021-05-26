package com.datastructure.other;


import java.util.Arrays;

/**
 * 旋转矩阵，旋转正方形
 *  int[][] arr = {
 *                 {1,2,3},
 *                 {4,5,6},
 *                 {7,8,9}
 *         };
 * 旋转后的数组
 *  int[][] arr1 = {
 *                 {7,4,1},
 *                 {8,5,2},
 *                 {9,6,3}
 *         };
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotateMatrix(arr);
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * 旋转打印矩阵
     * @param arr
     */
    public static void rotateMatrix(int[][] arr){
        int tR = 0; //左列
        int tC = 0;//这两个点代表着左上角的两个点 左行
        int dR = arr.length - 1; //右列
        int dC = arr[0].length - 1; //这两个点代表着右下角的两个点  右行
        while (tR < dR){
            rotateEdge(arr, tR++,tC++,dR--,dC--);
        }
    }
    public static void rotateEdge(int[][] m,int tR,int tC,int dR,int dC){
        int times = dC - tC;
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = m[tR][tC + i];
            m[tR][tC+i] = m[dR-i][tC];
            m[dR-i][tC] = m[dR][dC-i];
            m[dR][dC-i] = m[tR+i][dC];
            m[tR+i][dC] = tmp;
        }
//        System.out.println(times);
    }
}
