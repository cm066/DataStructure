package com.ntencent;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author cm
 * @create 2021/9/28-7:33 下午
 *合并k个有序数组
 */
public class MergerKListNode {


    /**
     * 解题的思路就是先将每条链表的头节点取出来构成一个小顶堆，然后每次取出来以后也加入小顶堆中去
     * @param node2s
     * @return
     */
    public static ListNode2 mergerKListNode(ListNode2[] node2s){
        ListNode2 head = new ListNode2(-1);
        ListNode2 tmp = head;
        PriorityQueue<ListNode2> pq = new PriorityQueue(new Comparator<ListNode2>() {
            @Override
            public int compare(ListNode2 o1, ListNode2 o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode2 node : node2s) {
            if (node != null){
               pq.add(node);
            }
        }
        while (!pq.isEmpty()){
            ListNode2 poll = pq.poll();
            if (poll.next != null) pq.add(poll.next);
            poll.next = null;
            tmp.next = poll;
            tmp = tmp.next;
        }
        return head.next;
    }
}
class ListNode2{
    int val;
    ListNode2 next;

    public ListNode2(int val) {
        this.val = val;
    }
}