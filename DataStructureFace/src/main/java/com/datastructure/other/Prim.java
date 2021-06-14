package com.datastructure.other;


import java.util.Arrays;

/**
 * 普里姆算法解决最小路生成问题
 */
public class Prim {

    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},
        };
        MGraph graph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(graph,verxs,data,weight);
        minTree.show(graph);

        minTree.prim(graph,0);
    }


}



//创建最小生成树-》村庄的图
class MinTree{
    /**
     *
     * @param graph 图对象
     * @param verxs 图对应的定点个数
     * @param data 图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph,int verxs,char[] data,int[][] weight){
        int i,j;
        for (i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    /**
     * 显示图
     * @param graph
     */
    public void show(MGraph graph){
        for (int[] ints : graph.weight) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     *
     * @param graph 图
     * @param v 表示从那个顶点出发
     */
    public void prim(MGraph graph,int v){
        int visited[] =new int[graph.verxs];
        visited[v] = 1;
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        for (int k = 1; k < graph.verxs; k++) {
            for (int i = 0; i < graph.verxs; i++) {
                for (int j = 0; j < graph.verxs; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight){
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("边<"+graph.data[h1]+","+graph.data[h1]+"> 权值："+minWeight);
            visited[h2] = 1;
            minWeight = 10000;
        }
    }
}
class MGraph{
    int verxs;//表示图的节点个数
    char[] data;//存储节点数据
    int[][] weight;//存放边，就是我们的邻接矩阵
    public MGraph(int verxs){
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}