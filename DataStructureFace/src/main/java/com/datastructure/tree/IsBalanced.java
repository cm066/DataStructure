package com.datastructure.tree;


/**
 * 判断一颗二叉树是否是平衡二叉树，平衡二叉树的定义是，任何一个子树的左右高度不超过1
 */
public class IsBalanced {


    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

}
