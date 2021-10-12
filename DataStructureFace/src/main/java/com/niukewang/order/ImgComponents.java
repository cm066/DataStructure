package com.niukewang.order;/*
 * Image Component Labeling
 * Project 2
 * < Chucheng Xie >
 * < 26/9/2021 >
 *
 * Purpose and usage of this application
 *   . . .
 *   . . .
 *
 */

import java.util.Random;
import java.util.Scanner;

public class ImgComponents {

    private static int componentNumber = 1; // increased when seed is encountered
    private static int density; // primitive double density constant
    private static int dimension; // primitive int dimension constant
//    private static int[][] dfsGrid, bfsGrid;
    static String path = ""; //表示有哪些路径
    static String shortestPath = ""; //表示最短路径

    // methods
    /* not yet implemented */
    private static void welcome() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Component Labeling project!");
        System.out.println("Enter image dimension <=5 and >=20:");
        dimension = sc.nextInt();
        System.out.println("Enter a density between 1 and 10:");
        density = sc.nextInt();
        System.out.println("Accepted Values\n" +
                "Dimension:" + dimension +
                "\nDensity:" + density +
                "\n\nGrids successfully created!");
    }

//    public static void getUserParams(int dimension, double density) {
//
//        bfsGrid = new int[dimension+2][dimension+2];
//        dfsGrid = new int[dimension+2][dimension+2];
//    }

    public static void initialize(int dimension, int density, int[][] dfsGrid, int[][] bfsGrid) {
        Random random = new Random();
        for (int row = 1; row < dimension; row++){
            for (int col = 1; col < dimension; col++) {
                int R = random.nextInt(10) +1;
                if (R < density) {
                    dfsGrid[row][col] = 1; // foreground
                    bfsGrid[row][col] = 1; // foreground
                }
                else {
                    dfsGrid[row][col] = 0; // background
                    bfsGrid[row][col] = 0; // background
                }
            }
        }

    }

    private static void outputImage(int[][] dfsGrid, int[][] bfsGrid) {

        System.out.println("The labeled image is dfsGrid");
        for (int i = 1; i < dimension; i++) {
            for (int j = 1; j < dimension; j++)
                System.out.print(dfsGrid[i][j] + "  ");
            System.out.println();
        }
//        System.out.println("The labeled image is bfsGrid");
//        for (int i = 1; i < dimension; i++) {
//            for (int j = 1; j < dimension; j++)
//                System.out.print(bfsGrid[i][j] + "  ");
//            System.out.println();
//        }
    }

    public static void dfsMaze(int x, int y, int[][] maze) {
        /*
         * 获得矩阵的大小
         * */
        int m=maze.length;
        int n=maze[0].length;
        //设置结束条件
        if (x < 0 || y < 0)
            return;
        // 如果坐标越界，或者 maze[x][y]==1 表示遇到障碍
        if (x > m - 1 || y > n - 1 || maze[x][y] ==1)
            return;
        //表示遇到障碍
        if (maze[x][y] == 1)
            return; // 判断是否通路和越界
        if (x == m - 1 && y == n - 1) { // 判断是否抵达出口
            path = path + "(" + x + "," + y + ")";
            if (shortestPath.length() == 0 || shortestPath.length() > shortestPath.length())
                shortestPath = path;
            System.out.println("找到路线:" + path);
            return;
        }
        String temp = path;
        path = path + "(" + x + "," + y + ")" + "-"; // 记录路线
        maze[x][y] = 1; // 将走过的路标记
        // 向四个方向搜索
        dfsMaze(x + 1, y, maze);  //向右搜索
        dfsMaze(x, y + 1, maze);  //向下搜索
        dfsMaze(x, y - 1, maze);  //向上搜索
        dfsMaze(x - 1, y, maze);  //向左搜索
        // 将路线和标记恢复成上一次的状态
        maze[x][y] = 0;
        //清除
        path = temp;
    }


    public static void main(String[] args) {
        welcome();
//        getUserParams(dimension, density);
        // get primitive int dimension & double density from wrapper objects
//        initialize(dimension, density, dfsGrid, bfsGrid);
        int[][] m1 = new int[dimension][dimension];
        int[][] m2 = new int[dimension][dimension];
        initialize(dimension, density, m1, m2);
        outputImage(m1,m2);
        dfsMaze(0,0,m1);
        if (shortestPath.length() != 0)
            System.out.println("最短路线为：" + shortestPath);
        else
            System.out.println("没有找到路线！");
//        dfsMaze(1,0,dfsGrid);
        // printout user params and grid1 and grid2
        // continue on next slide.
//        for (int row = 1; row <= dimension; row++) // Scan either dfs
//            for (int col = 1; col <= dimension; col++) // or bfs grid
//                if (dfsGrid[row][col].label == 1) {
//                    componentNumber++;
//                    labelUsingDFS(dfsGrid, row, col, componentNumber, stack);
//                    labelUsingBFS(bfsGrid, row, col, componentNumber, queue);
//                }
    }

}
