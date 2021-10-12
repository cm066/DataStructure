package com.datastructure.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化二叉树
 */
public class SerialTree {

    public static void main(String[] args) {

    }

    /**
     * 前序序列化
     *
     * @param head
     * @return
     */
    public static String preSerialTree(TreeNode head) {
        if (head == null) {
            return "#_";
        }
        String res = head.val + "_";
        res += preSerialTree(head.left);
        res += preSerialTree(head.right);
        return res;
    }

    public static TreeNode reconPreOrderString(String preStr) {
        String[] s = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < s.length; i++) {
            queue.add(s[i]);
        }
        return reconPreOrder(queue);
    }

    public static TreeNode reconPreOrder(Queue<String> queue) {

        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

}
