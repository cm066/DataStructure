package com.datastructure.other;

/**
 * 以动态规划的思想去解决0，1背包问题，动态规划简单点的来说，就是后一个的结果受前一个结果的影响
 */
public class DynamicBack01 {


    public static void main(String[] args) {
        int[] w = {1, 4, 3};
        int[] val = {1500, 3000, 2000};
        int m = 4;
        int n = val.length;
        int[][] v = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1];
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }

        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {

                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
//                    v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                }
            }
        }

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.printf(v[i][j] + " ");
            }
            System.out.println();
        }

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i - 1];
            }
            i--;
//            System.out.println();
        }
    }


}
