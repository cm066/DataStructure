package com.datastructure.tree;


import com.datastructure.linked.ReverseLinkedList;

import javax.naming.ldap.HasControls;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定两个节点，求出他们的最低公共祖先，简单的来说就是最开始相交的地方
 */
public class LowerCommonAnster {

    public static void main(String[] args) {

    }

    /**
     * 采用递归的方式来实现的
     *
     * @param head
     * @param o1
     * @param o2
     * @return
     */
    public static TreeNode lca1(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null || head == o1 || head == o2) {
            return head;//这个是第一种情况，就是两个节点中有一个节点是公共祖先
        }
        TreeNode left = lca1(head.left, o1, o2);
        TreeNode right = lca1(head.right, o1, o2);
        if (right != null && left != null) {
            return head;
        }
        return left != null ? left : right;
    }

    /**
     * 这个是采用额外的空间来的
     *
     * @param head
     * @param node1
     * @param node2
     * @return
     */
    public static TreeNode lca(TreeNode head, TreeNode node1, TreeNode node2) {
        Map<TreeNode, TreeNode> fatherMap = new HashMap<>();
        process(head, fatherMap);
        TreeNode cur = node1;
        HashSet<TreeNode> set1 = new HashSet<>();
        while (node1 != fatherMap.get(cur)) {
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(head);
        cur = node2;
        while (!set1.contains(cur)) {
            cur = fatherMap.get(cur);
        }
        return fatherMap.get(cur);
    }

    public static void process(TreeNode head, Map<TreeNode, TreeNode> fatherMap) {
        if (head == null) {
            return;
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }
}
