package com.datastructure.other;


import java.util.Arrays;

/**
 * 最短路径
 */
public class Dijkstra {

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;//表示不可以连接
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};
        Graph graph = new Graph(vertex, matrix);
        graph.show();
    }
}


class Graph {
    private char[] vertex;
    private int[][] matrix;//邻接矩阵
    private VisitedVertex vv;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void show() {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
    //dijkstra算法实现

    /**
     * 表示出发顶点对应的下标
     *
     * @param index
     */
    public void dsj(int index) {
        vv = new VisitedVertex(vertex.length, index);
    }

    private void update(int index) {
        int len = 0;
        for (int j = 0; j < matrix[index].length; j++) {
            len = vv.getDis(index) + matrix[index][j];
            if (!vv.in(j) && len < vv.getDis(j)) {
                vv.updatePre(j, index);
                vv.updateDis(j, len);
            }

        }
    }
}

class VisitedVertex {
    //记录各个顶点是否访问过了
    public int[] already_arr;
    //记录每个下表对应的只为前一个顶点下标，会动态更新
    public int[] pre_visited;
    //记录出发点到其他所有顶点的距离，比如G点出发，就会记录G到其他顶点的距离
    public int[] dis;

    /**
     * @param length 表示顶点的个数
     * @param index  出发顶点的下表
     */
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        Arrays.fill(dis, 65535);
        this.already_arr[index] = 1;
        this.dis[index] = 0;//设置出发顶点的访问距离为零
    }

    /**
     * 判断index顶点是否被访问过
     *
     * @param index
     * @return 如果被访问过，就返回true，否则返回false
     */
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    /**
     * 更新出发顶点到index顶点的距离
     *
     * @param index
     * @param len
     */
    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    /**
     * 更新顶点的前驱节点
     * 更新pre这个顶点的前驱节点为index顶点
     *
     * @param pre
     * @param index
     */
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    /**
     * 功能：返回出发顶到到index顶点的距离
     *
     * @param index
     * @return
     */
    public int getDis(int index) {
        return dis[index];
    }

    /**
     * 继续选着并返回新的访问顶点，比如这里的G完成后，就是A点作为新的访问顶点（注意不是新的的顶点）
     *
     * @return
     */
    public int updateArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        //更新当前这个点是被访问过了的
        already_arr[index] = 1;
        return index;
    }
}