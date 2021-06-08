package com.datastructure.linked;

/**
 * 合并两个有序的链表
 */
public class MergeTwoLists {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null || l2 == null ){
            return l1 == null ? l2:l1;
        }
        ListNode head = new ListNode();;
        ListNode last = head;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
               last.next = l2;
               l2 = l2.next;
            }else {
                last.next = l1;
                l1 = l1.next;
            }
            //尾部指针往后移动
            last = last.next;
        }
        if (l1 != null){
          last.next = l1;
        }
        if (l2 != null){
           last.next = l2;
        }
        return head;

    }
}
