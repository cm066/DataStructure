package com.datastructure.tree;


import java.util.Stack;

/**
 * 遍历树
 */
public class PrintTree {

    public static void main(String[] args) {

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1,left,right);
//        prePrint(root);
        System.out.println("---------------");
//        prePrint1(root);
        orderPrint(root);
    }

    /**
     * 第一种方式，采用递归的方式前序打印树，前序打印是先打印自己，然后是左子树，然后是右子树
     * @param root
     */
    public static void prePrint(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.val);
        prePrint(root.left);
        prePrint(root.right);

    }

    /**
     * 采用迭代的方式去打印
     */
    public static void prePrint1(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        if (root == null){
            return;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }

    }

    /**
     * 采用迭代的方式，中续打印二叉树
     * @param root
     */
    public static void orderPrint(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                TreeNode node = stack.pop();
                System.out.println(node.val);
                root = node.right;
            }
        }
    }

    /**
     * TODO
     * 迭代后续打印二叉树
     * @param root
     */
    public static void inorder(TreeNode root){

    }
}
