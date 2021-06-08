package com.datastructure.tree;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 验证一个树是否树搜索二叉树
 */
public class IsValidBST {
    public static void main(String[] args) {

    }

    /**
     * 第一种方法，因为搜索二叉树的中序遍历是升序的，所以采用一个集合装，遍历完二叉树，在遍历集合
     * @param root
     * @return
     */
    public  boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null){

            //先压左子树
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if ( root.val <= inorder){
                return false;
            }
            inorder = root.val;
            //在压又子树
            root = root.right;
        }
        return true;
    }
//    public  boolean isValidBST1(TreeNode root) {
//        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//    public boolean isValidBST(TreeNode node, long lower, long upper) {
//
//    }


}
