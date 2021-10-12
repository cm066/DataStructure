package com.csdn;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 合并几个有序的链表，跟之前的合并两个有序的链表有点相识
 */
public class MergeKLists {

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

        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(5);
        ListNode node14 = new ListNode(7);
        ListNode node15 = new ListNode(9);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        ListNode[] lists = {node1,node5,node11};
        ListNode listNode = mergeKLists(lists);
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
     * 第一种解法，就是遍历所有链表，然后将链表的值存到数组中，然后进行排序，然后在创建出来
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> l = new ArrayList<Integer>();
        for (ListNode list : lists) {
          while (list != null){
              l.add(list.val);
              list = list.next;
          }
        }
        System.out.println(l);
        Collections.sort(l);
        ListNode res1 = new ListNode(0);
        ListNode res = res1;
        for (Integer i : l) {
            ListNode r = new ListNode(i);
            res.next = r;
            res = res.next;
        }

        return res1.next;
    }
}
