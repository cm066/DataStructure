package com.ntencent;

/**
 * @author cm
 * @create 2021/9/26-11:03 下午
 *
 * 二叉树中两个节点的公共祖先
 * TODO
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(1);
        TreeNode2 node2 = new TreeNode2(2);
        TreeNode2 node3 = new TreeNode2(3);
        TreeNode2 node4 = new TreeNode2(4);
        TreeNode2 node5 = new TreeNode2(5);
        TreeNode2 node6 = new TreeNode2(6);
        TreeNode2 node7 = new TreeNode2(7);
        node4.right = node5;
        node4.left = node6;
        node2.left = node3;
        node2.right = node4;
        root.right = node7;
        root.left = node2;
        int i = lowestCommonAncestor(root, 3, 5);
        System.out.println(i);
    }
    public static int lowestCommonAncestor (TreeNode2 root, int o1, int o2) {
        return CommonAncestor(root, o1, o2).val;
    }
    public static TreeNode2 CommonAncestor (TreeNode2 root, int o1, int o2) {
        if(root == null || root.val == o1 || root.val == o2){
            return root;
        }
        TreeNode2 left = CommonAncestor(root.left,o1,o2);
        TreeNode2 right  =CommonAncestor(root.right,o1,o2);
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        return root;
    }
}


class TreeNode2{
    int val;
    TreeNode2 left;
    TreeNode2 right;

    public TreeNode2(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode2 getLeft() {
        return left;
    }

    public void setLeft(TreeNode2 left) {
        this.left = left;
    }

    public TreeNode2 getRight() {
        return right;
    }

    public void setRight(TreeNode2 right) {
        this.right = right;
    }
}