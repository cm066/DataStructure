package com.csdn;


/**
 * 给定一个链表两两交换他们的位置
 */
public class SwapPairs24 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode listNode = swapPairs(node1);
        ListNodeUitls.print(listNode);
    }


    /**
     * 采用递归的方式来实现
     * @param head
     * @return
     */
    public static ListNode swapPairs1(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
    /**
     * 第一种方法采用迭代的方式来解决
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode point = dummy;
        while (point.next != null && point.next.next != null){
            ListNode swap1 = point.next;
            ListNode swap2 = point.next.next;
            point.next = swap2;
            swap1.next = swap2.next;//这一步是保证链表不会断
            swap2.next = swap1;
            point = swap1;
        }
        return dummy.next;
    }
}
