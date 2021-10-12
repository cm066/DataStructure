package com.ntencent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cm
 * @create 2021/9/15-9:18 下午
 * 腾讯 牛课网 树的前、中、后遍历
 */
public class PrintTreeNode {
    int preIndex = 0;

    List<Integer> list = new ArrayList<>();
    /**
     * 树的前序遍历，先自己，左，右
     * @param root
     */
    public  void prePrint(TreeNode root) {
        if (root == null) return;
        list.add(root.value);
        prePrint(root.left);
        prePrint(root.right);
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, null, null);
        TreeNode right = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, left, right);
        PrintTreeNode node = new PrintTreeNode();
        node.prePrint(root);
        System.out.println(node.list);
        node.list.clear();
    }
}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }
    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}