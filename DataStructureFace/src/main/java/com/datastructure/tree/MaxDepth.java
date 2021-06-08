package com.datastructure.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 求一个二叉树的最大深度
 */
public class MaxDepth {

    public static void main(String[] args) {

    }


    /**
     * 采用递归的方式来实现的，深度优先
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            int leftDeep = maxDepth(root.left);
            int rigthDeep = maxDepth(root.right);
            return Math.max(leftDeep,rigthDeep)+1;
        }
    }

    /**
     * 广度优先，每次遍历完一层以后就将保存高度的变量加一
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            ans++;
        }
        return ans;
    }


}
