package com.datastructure.other;


/**
 * 转圈打印矩阵
 * rotateMatrix
 */
public class PrintMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        printMatrix(arr);
    }

    /**
     * 转圈圈打印矩阵
     *
     * @param arr
     */
    public static void printMatrix(int[][] arr) {
        int tR = 0;
        int tC = 0;//这两个点代表着左上角的两个点
        int dR = arr.length - 1;
        int dC = arr[0].length - 1; //这两个点代表着右下角的两个点
        while (tR <= dR && tC <= dC) {
            printEdge(arr, tR++, tC++, dR--, dC--);
        }
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
    public static void printEdge(int[][] arr, int tR, int tC, int dR, int dC) {
        //要考虑只有一行或者只有一列的情况
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                System.out.print(arr[tR][i] + " ");
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                System.out.print(arr[tC][i] + " ");
            }
        } else {
            int curC = tC; //左上角的横坐标
            int curR = tR; //左上角的纵坐标
            //从左往右打印
            while (curC != dC) {
                System.out.print(arr[tR][curC] + " ");
                curC++;
            }
//            System.out.println();
            //从上往下打印
            while (curR != dR) {
                System.out.print(arr[curR][dC] + " ");
                curR++;
            }
//            System.out.println();
            //从右往左
            while (curC != tC) {
                System.out.print(arr[dR][curC] + " ");
                curC--;
            }
//            System.out.println();
            //从上往下打印
            while (curR != tR) {
                System.out.print(arr[curR][tC] + " ");
                curR--;
            }
            System.out.println();
        }
    }
}
