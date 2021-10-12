package com.datastructure.bibi;


import java.util.Arrays;

/**
 * 转圈打印矩阵
 * rotateMatrix
 */
public class PrintMatrix {
    private static int index = 0;

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        int[] ints = printMatrix(arr);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 转圈圈打印矩阵
     *
     * @param matrix
     */
    public static int[] printMatrix(int[][] matrix) {
        int[] res = new int[matrix[0].length * matrix.length];
        int tR = 0;
        int tC = 0;//这两个点代表着左上角的两个点
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1; //这两个点代表着右下角的两个点
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--, res);
        }
        return res;
    }

    /**
     * 转化一下思想就是打印边
     *
     * @param arr
     * @param tR
     * @param tC
     * @param dR
     * @param dC
     */
    public static void printEdge(int[][] arr, int tR, int tC, int dR, int dC, int[] res) {
        //要考虑只有一行或者只有一列的情况
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                res[index++] = arr[tR][i];
//                System.out.print(arr[tR][i] +" ");
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                res[index++] = arr[tC][i];
//                System.out.print(arr[tC][i] +" ");
            }
        } else {
            int curC = tC; //左上角的横坐标
            int curR = tR; //左上角的纵坐标
            //从左往右打印
            while (curC != dC) {
                res[index++] = arr[tR][curC];
//                System.out.print(arr[tR][curC] +" ");
                curC++;
            }
//            System.out.println();
            //从上往下打印
            while (curR != dR) {
                res[index++] = arr[curR][dC];
//                System.out.print(arr[curR][dC] +" ");
                curR++;
            }
//            System.out.println();
            //从右往左
            while (curC != tC) {
                res[index++] = arr[dR][curC];
//                System.out.print(arr[dR][curC] +" ");
                curC--;
            }
//            System.out.println();
            //从上往下打印
            while (curR != tR) {
                res[index++] = arr[curR][tC];
                System.out.print(arr[curR][tC] + " ");
                curR--;
            }
            System.out.println();
        }
    }
}
