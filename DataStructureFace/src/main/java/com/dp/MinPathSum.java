package com.dp;

/**
 * @author cm
 * @create 2021/11/14-6:48 下午
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}};
        int i = minPathSum1(grid);
        int[][] nums = {{1,2,3},
                {4,5,6}};
        int i1 = minPathSum1(nums);
        System.out.println(i1);
        System.out.println(i);
    }

    public static int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];

        for (int i = 0; i < columns; i++) {
            if (i == 0){
                dp[0][i] = grid[0][i];
            }else {
                dp[0][i] = dp[0][i-1]+grid[0][i];
            }
        }
        for (int j = 1; j < rows; j++) {
          dp[j][0] = dp[j-1][0]+grid[j][0];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min((dp[i-1][j]+grid[i][j]),(dp[i][j-1]+grid[i][j]));
            }
        }
        return dp[rows-1][columns-1];
    }
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }
}
