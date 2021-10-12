package com.csdn;


/**
 * ListNode 操作链表的一些公共工具
 */
public class ListNodeUitls {
    public static void print(ListNode node){
        if (node == null)return;
        ListNode n = node;
        while (n != null){
            System.out.print(n.val +"->");
            n = n.next;
        }
    }
}
