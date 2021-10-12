package com.csdn;

/**
 * 两个链表相加
 */
public class TwoListNodeAdd {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //结果的头节点，只是为了下面不用去判断是否有头节点
        ListNode resultHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode cur = resultHead;
        int carry = 0;//这个变量就是判断前两个节点是否进位了，初始值为0
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;//这个操作就是判断当前的两个节点的值是否大于10，若大于10就进位
            cur.next = new ListNode(sum % 10);//这个就是把当前两个节点的和创建一个新节点
            q = (q != null ? q.next : null);
            p = (p != null ? p.next : null);
        }
        //出循环以后要判断carry当前的值，如不为0，说明
        if (carry != 0) {
            cur.next = new ListNode(1);
        }

        return resultHead.next;
    }
}
