package com.ntencent;

/**
 * @author cm
 * @create 2021/10/12-10:01 下午
 */
public class EntryNodeOfLoop {
    public static void main(String[] args) {
        ListNode3 node1 = new ListNode3(3);
        ListNode3 node2 = new ListNode3(2);
        ListNode3 node3 = new ListNode3(0);
        ListNode3 node4 = new ListNode3(4);
        node4.next = node2;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        ListNode3 listNode3 = entryNodeOfLoop(node1);
        System.out.println(listNode3.val);
    }
//    public ListNode3 entryNodeOfLoop3(ListNode3 pHead) {}
    public static ListNode3 entryNodeOfLoop(ListNode3 pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode3 fast = pHead;
        ListNode3 slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = pHead;
                while (fast != null) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}

class ListNode3 {
    int val;
    ListNode3 next = null;

    public ListNode3(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode3 getNext() {
        return next;
    }

    public void setNext(ListNode3 next) {
        this.next = next;
    }


}