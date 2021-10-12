package com.datastructure.linked;


/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairs {

    public static void main(String[] args) {

    }

    /**
     * 交换链表相邻的位置，不只是交换值
     * 相当于是采用的是快慢指针
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode resHead = new ListNode(0);
        resHead.next = head;
        ListNode temp = resHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return head.next;

    }
}
