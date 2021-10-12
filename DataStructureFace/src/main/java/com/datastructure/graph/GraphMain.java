package com.datastructure.graph;


/**
 * 深度优先遍历的算法步骤
 * 1、访问初始节点v，并标记节点v为已访问
 * 2、查找节点v的第一个邻接节点w
 * 3、若w存在，则继续执行4，如果w不存在，则回到第一步，将从v的下一个结点继续
 * 4、若w未被访问，对w进行深度优先遍历递归，则把w当做另一个v，然后进行步骤1，2，3
 * 5查找结点v的w邻接结点，转到步骤3
 */
public class GraphMain {

    public static void main(String[] args) {
        int n = 5;
        String Vertexs[] = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        for (String vertex : Vertexs) {
            graph.insertVertex(vertex);
        }
        //添加边
        //a-b a-c b-c b-d b-e
        graph.insertEdge(0, 1, 1);//表示的是a-b这条边，权重为1
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        //显示邻接矩阵
        graph.showGraph();
//        System.out.println("图的深度遍历dfs");
//        graph.dfs();
        System.out.println("图的广度优先");
        graph.bfs();
    }
}
