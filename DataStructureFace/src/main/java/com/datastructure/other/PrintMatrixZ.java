package com.datastructure.other;


/**
 * TODO
 * Z字型打印一个二维数组，要从宏观的思想去看这个，不能从局部去看待这个问题
 */
public class PrintMatrixZ {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        printMatrixZ(arr);
    }

    /**
     * Z字型打印
     *
     * @param arr
     */
    public static void printMatrixZ(int[][] arr) {
        int aR = 0;//行
        int aC = 0;//列
        int bR = 0;//行
        int bC = 0;//列
        int endR = arr.length - 1;//两个点是终点，结束点的位置 行
        int endC = arr[0].length - 1; // 列
        boolean formUp = false;
        while (aR != endR + 1) {
            printLevel(arr, aR, aC, bR, bC, formUp);
            aR = aC == endC ? aR + 1 : aR;
            aC = aC == endC ? aC : aC + 1;
            bC = bR == endR ? bC + 1 : bC;
            bR = bR == endR ? bR : bR + 1;
            formUp = !formUp;
            System.out.println();
        }

    }

    public static void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
        if (!f) {
            //从上往下打印
            while (tR != dR + 1) {
                System.out.print(m[tR++][tC--]);
            }
        } else {
            //从下往上打印
            while (dC != tC + 1) {
                System.out.print(m[dR--][dC++]);
            }
        }
    }
}
