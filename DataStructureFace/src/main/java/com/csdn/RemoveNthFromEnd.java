package com.csdn;


import java.util.ArrayList;
import java.util.List;

/**
 *删除倒数第n个节点，然后返回被删除后的链表
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode listNode = removeNthFromEnd2(node1, 2);
        print(listNode);
    }

    public static void print(ListNode node){
        if (node == null)return;
        ListNode n = node;
        while (n != null){
            System.out.print(n.val +"->");
            n = n.next;
        }
    }


    /**
     * 这个算法采用的是空间来换时间的算法
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        List<ListNode> l = new ArrayList<ListNode>();
        ListNode h = head;
        int len = 0;
        while (h != null){
            l.add(h);
            h = h.next;
            len++;
        }
        int remove = len - n;
        if (len == 1){
            return null;
        }
        if (remove == 0){
            return head.next;
        }
        ListNode node = l.get(remove - 1);
        node.next = node.next.next;
        return head;
    }
    /**
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode l = temp;
        ListNode nl = temp;
        for (int i =1 ; i <= n+1; i++) {
            nl = nl.next;
        }
        while (nl != null){
            nl = nl.next;
            l = l.next;
        }
        System.out.println(l.val);
        l.next = l.next.next;
        return temp.next;
    }
    /**
     * 第一种解法，就是先遍历出这个链表总共的节点，然后在减去n就可以得出要删除的节点
     * 这个是没有头节点，所以要判断是否删除的是第一个节点或者是只有一个节点
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int sum = 0;
        ListNode h = head;
        while (h != null){
            h = h.next;
            sum++;
        }
        if (sum == 1) {
            return null;
        }
        int rm_node_index = sum - n;
        //如果删除的是头结点
        if (rm_node_index == 0) {
            return head.next;
        }
        h = head;
        ListNode pre = null;
        for (int i = 0; i < rm_node_index ; i++) {
            pre = h;
            h = h.next;
        }
        pre.next = h.next;

        return head;
    }
}
