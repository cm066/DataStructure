package com.datastructure.other;

import java.util.Arrays;

public class Kru {
    private int edgeNum;//边的个数
    private char[] vertexs;//顶点的数组
    private int[][] matrix;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[]  vertexs = new char[]{'A','B','C','D','E','F','G'};
        int[][] matrix ={
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0}
        };
        Kru kru = new Kru(vertexs, matrix);
        kru.show();
        EData[] edges = kru.getEdges();
        System.out.println(Arrays.toString(edges));
        kru.sortEdges(edges);
        System.out.println(Arrays.toString(edges));
        kru.kruskal();
    }
    public Kru(char[] vertexs,int[][] matrix){
        int vlen = vertexs.length;
        this.vertexs = new char[vlen];
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        //统计边
        for (int i = 0; i < vlen; i++) {
            for (int j = i+1; j < vlen; j++) {
                if (this.matrix[i][j] != INF){
                    edgeNum++;
                }
            }
        }
    }

    public void  show(){
        System.out.println("邻接矩阵为：\n");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d\t",matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 对边进行排序
     * @param edges
     */
    public void sortEdges(EData[] edges){
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length-1-i; j++) {
                if (edges[j].weight > edges[j+1].weight){
                    EData tmp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = tmp;
                }
            }
        }
    }

    /**
     * 跟对对应的字符取出它的下标
     * @param ch
     * @return
     */
    public int getPosition(char ch){
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch){
                return i;
            }
        }
        return -1;
    }

    /**
     * 构建边的对象并放入数组中
     * @return
     */
    private EData[] getEdges(){
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF){
                    edges[index++] = new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标为i的定点的终点，用于后面判断两个定点的终点是否相同
     * @param ends 数组就是记录了各个顶点对应的终点是那个，ends数组是在遍历的过程中逐步形成的
     * @param i 表示传入的顶点对应的下标
     * @return 返回的就是下标为i这个定点对应的终点的下标
     */
    private int getEnd(int[] ends,int i){
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
    public void kruskal(){
        int index = 0;
        int[] ends = new int[edgeNum];
        EData[] res = new EData[edgeNum];
        EData[] edges = getEdges();
        sortEdges(edges);//从小到大排序
        //遍历 edges数组，每次都拿最小的一条边，还需要判断准备加入的一条边是否构成回路
        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);
            //获取p1这个顶点在已有的终点
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            //判断是否构成回路
            if ( m != n){
                ends[m] = n;
                res[index++] = edges[i];//有一条边加入了结果中
            }
        }
        System.out.println("最小生成树为："+Arrays.toString(res));
    }
}

/**
 * 一个对象即表示为一条边
 */
class EData{

    char start;//边的起点
    char end;//边的另外一个点
    int weight;//边的权重
    public EData(char start,char end,int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
