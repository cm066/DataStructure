package com.datastructure.linked;

import java.util.HashSet;

/**
 * 判断一个链表是否有环
 */
public class HasCycle {


    /**
     * 第二种方法，采用快慢指针的方法来实现，如果有环，快慢指针始终会相遇
     *
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 第一种方法采用一个集合去装节点，如果后面加入的时候集合里面出现有了
     * 就说明有环，反之就是没有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur)) {
                return true;
            } else {
                set.add(cur);
            }
            cur = cur.next;
        }
        return false;
    }
}
