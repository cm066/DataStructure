package com.csdn;


/**
 * 合并两个两个有序对链表，将两个有序对链表合并成一个有序对链表
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(7);
        ListNode node9 = new ListNode(8);
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        ListNode listNode = mergeTwoLists1(node1, node5);
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
     * 采用递归的方式来实现
     * @param l1
     * @param l2
     * todo 没有理解到这个递归的思想（差不多理解，但是需要加强理解）
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
    /**
     * 第一种方式采用迭代对方式来实现
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans = h;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                ans.next = l1;
                l1 = l1.next;
                ans = ans.next;
            }else {
                ans.next = l2;
                l2 = l2.next;
                ans = ans.next;
            }
        }
        /**
         * 到这里还需要判断一下，因为两个链表有可能不一样长，所以有可能有一个链表没有遍历完
         */
        if (l1 != null){
            ans.next = l1;
        }
        if (l2 != null){
            ans.next = l2;
        }
        return h.next;
    }
}
