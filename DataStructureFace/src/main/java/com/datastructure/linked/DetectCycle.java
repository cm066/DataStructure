package com.datastructure.linked;

/**
 * 如果一个链表是有环的就换回入换的第一个节点，反之就返回null
 */
public class DetectCycle {

    /**
     *采用的是快慢指针的方式来实现的，空间复杂度为O(1)
     * 思想就是想利用快慢指针的思想去判断是否有环，如果有环，才利用一个临时指针去找慢指针
     * 两个指针相遇的时候就是第一个入环节点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null){
            slow = slow.next;;
            if (fast.next != null){
                fast = fast.next.next;
            }else {
                return null;
            }
            if (fast == slow){
                ListNode res = head;
                while (res != slow){
                    res = res.next;
                    slow = slow.next;
                }
                return res;
            }
        }
        return null;
    }
}
