package com.datastructure.tree;

import java.util.Stack;

/**
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1],targetSum = 22
 *  输出：true
 *  给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，
 *  判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。

 */

/**
 * TODO 查找是否有这个路径
 */
public class HasPathSum {
    public static void main(String[] args) {

    }

    /**
     * 采用迭代的方式去遍历树，然后加上这个树
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {

        return false;
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
