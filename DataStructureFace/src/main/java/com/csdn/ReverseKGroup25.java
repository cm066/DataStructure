package com.csdn;


/**
 * 给定一个链表，然后给定指定的步数并将其倒专，若不够那么多就直接返回
 *
 * TODO 周末解决这个问题，单链表的反转还不是很理解
 */
public class ReverseKGroup25 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode listNode = reverse1(node1);
        ListNodeUitls.print(listNode);
    }


    /**
     *  第一种方法采用迭代的方式来
     * @param head 链表
     * @param k 几步反转一下
     * @return 将反转好的链表反转回去
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        return null;
    }




    /**
     * 反转部分链表，就跟反转单向链表一样
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        ListNode current_head = head;
        while (head != null) {
            ListNode next = head.next;
            head.next = current_head;
            current_head = head;
            head = next;
        }
        return current_head;
    }


    public static ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    /**
     *  采用递归的方式来实现单向链表的反转
     *  todo
     * @param head
     * @return
     */
    public static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) //递归结束的条件
            return head;
        ListNode tmp = head.next;
        ListNode newHead = reverse2(head.next);
        tmp.next = head;
        head.next = null;
        return newHead;

    }
    /**
     * 反转单向链表，相当于是每次都把拿出来的节点放在最前面，
     * 之前的节点接入到这个节点的后面
     * @param head
     * @return
     */
    public static ListNode reverse1(ListNode head) {
        ListNode newHead = null;//要返回的新的头节点
        ListNode next = null;//下一次要访问的节点
        while (head != null){
            next = head.next;//保存下一个节点，防止链表断掉
            head.next = newHead;//将链表断开
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
