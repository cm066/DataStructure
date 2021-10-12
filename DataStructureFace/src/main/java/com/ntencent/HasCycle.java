package com.ntencent;

/**
 * @author cm
 * @create 2021/9/21-11:08 下午
 * 判断一个链表是否有环
 */
public class HasCycle {
    public static void main(String[] args) {
    }

    public boolean hasCycle1(ListNode1 head) {
        if(head==null) {
            return false;
        }
        ListNode1 fast=head;
        ListNode1 slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) {
                return true;
            }
        }
        return false;
    }
    /**
     * 其实这类题有很多种解题的方法
     * 1、可以采用集合的方式，但是这样会用额外的空间
     * 2、采用快慢指针的方式来解决
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode1 head) {
        if (head == null || head.next == null || head.next.next == null) return false;
        ListNode1 slow = head;
        ListNode1 fast = head.next;
        while (fast != slow){
            if(slow == null || fast == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
class ListNode1{
    int val;
    ListNode1 next;

    public ListNode1() {
    }

    public ListNode1(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode1 getNext() {
        return next;
    }

    public void setNext(ListNode1 next) {
        this.next = next;
    }
}