package com.niukewang.order;

import java.util.Random;
import java.util.Scanner;

/**
 * @author cm
 * @create 2021/9/29-10:38 下午
 */
public class DFSMaze {

    private static int density; // primitive double density constant
    private static int dimension;
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

    public static void initialize(int dimension, int density, int[][] dfsGrid, int[][] bfsGrid) {
        Random random = new Random();
        for (int row = 1; row <= dimension; row++){
            for (int col = 1; col <= dimension; col++) {
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
    /**
     * DFS算法解决走迷宫问题
     * 0: 表示通路
     * 1: 表示死路
     *
     */
    static String path = "";
    static String shortestPath = "";

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
        // 初始化一个迷宫地图
        // 0: 表示通路
        // 1:表示死路
        int[][] maze = {
                {0, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0}
        };
        /**
         * 找到路线:(0,0)-(0,1)-(1,1)-(2,1)-(3,1)-(4,1)-(5,1)-(5,2)-(6,2)-(7,2)-(7,3)-(7,4)-(7,5)-(7,6)-(7,7)-(7,8)-(8,8)
         * 找到路线:(0,0)-(0,1)-(1,1)-(2,1)-(3,1)-(4,1)-(5,1)-(5,2)-(5,3)-(5,4)-(5,5)-(6,5)-(7,5)-(7,6)-(7,7)-(7,8)-(8,8)
         * 找到路线:(0,0)-(0,1)-(1,1)-(1,2)-(1,3)-(1,4)-(2,4)-(3,4)-(3,3)-(4,3)-(5,3)-(5,4)-(5,5)-(6,5)-(7,5)-(7,6)-(7,7)-(7,8)-(8,8)
         * 找到路线:(0,0)-(0,1)-(1,1)-(1,2)-(1,3)-(1,4)-(2,4)-(3,4)-(3,3)-(4,3)-(5,3)-(5,2)-(6,2)-(7,2)-(7,3)-(7,4)-(7,5)-(7,6)-(7,7)-(7,8)-(8,8)
         * 最短路线为：(0,0)-(0,1)-(1,1)-(2,1)-(3,1)-(4,1)-(5,1)-(5,2)-(6,2)-(7,2)-(7,3)-(7,4)-(7,5)-(7,6)-(7,7)-(7,8)-(8,8)
         */

        int[][] maze2 = {
                {0, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0}
        };
        int[][] m3 = {
                {1 , 1 , 1 , 1  ,1  ,1 , 0 , 0 , 0 , 1},
                {1 , 0  ,0 , 0 , 1,  0  ,1  ,0 , 0 , 1},
                {0 , 0  ,1  ,1  ,0  ,1  ,0  ,0  ,0  ,1},
                {0  ,0  ,0  ,0  ,1  ,0  ,0  ,1  ,0  ,0},
                {0  ,1  ,0  ,0  ,0  ,0  ,1  ,1  ,0  ,1},
                {0  ,0  ,0  ,1  ,0  ,1  ,0  ,0  ,1  ,0},
                {1  ,0  ,0  ,1  ,0  ,1  ,0  ,1  ,1  ,0},
                {1  ,0  ,0  ,1  ,0  ,0  ,0  ,1  ,1  ,1},
                {0 , 0  ,1 , 1  ,0  ,1  ,1 , 0 , 0  ,1},
                {0  ,0 , 1  ,0 , 1  ,1  ,0  ,1 , 0 , 0 }};
        /*
         * 从矩阵的左上角位置开始搜索
         * */
        dfsMaze(0, 0, maze);
        if (shortestPath.length() != 0)
            System.out.println("最短路线为：" + shortestPath);
        else
            System.out.println("没有找到路线！");


    }
}
