package com.datastructure.tree;


/**
 * 验证一个二叉树是否是满二叉树，满二叉树的个数的是2的n次方-1，n为树的高度
 */
public class IsFullTree {

    public static void main(String[] args) {

    }

    public static boolean isFull(TreeNode node){
        Info process = process(node);
        return process.nodes == (1<< process.height -1);
    }

    public static Info process(TreeNode node){
        if (node == null){
            return new Info(0,0);
        }
        Info leftNode = process(node.left);
        Info rightNode = process(node.right);
        int height = Math.max(leftNode.height ,rightNode.height)+1;
        int nodes = leftNode.nodes + rightNode.nodes +1;
        return new Info(height,nodes);
    }



    public static class Info{
        public int height;
        public int nodes;

        public Info(int height,int nodes){
            this.height = height;
            this.nodes = nodes;
        }
    }
}
