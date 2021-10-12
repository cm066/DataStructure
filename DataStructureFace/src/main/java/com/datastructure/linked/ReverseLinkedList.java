package com.datastructure.linked;


/**
 * 单向链表和双向链表的反转
 */
public class ReverseLinkedList {

    public class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }

        public Node() {

        }

        //打印链表
        public void pint(Node head) {
            while (head != null) {
                System.out.print(head.value + "->");
                head = head.next;
            }
        }
    }

    public class DoubleNode {
        public int value;
        public DoubleNode next;
        public DoubleNode last;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {

        ReverseLinkedList p1 = new ReverseLinkedList();
        ReverseLinkedList.Node node = p1.new Node();
        Node n1 = p1.new Node(1);
        Node n2 = p1.new Node(2);
        Node n3 = p1.new Node(3);
        n1.next = n2;
        n2.next = n3;
        node.pint(n1);
        Node node1 = reverseNode(n1);
        node.pint(node1);
    }

    /**
     * 双向链表的反转
     *
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleNode(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }


    /**
     * 单向链表的反转
     *
     * @param head
     * @return
     */
    public static Node reverseNode(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 删除单链表给定的一个节点，并返回删除后的链表
     * 链表中可能出现节点的值相等的节点
     *
     * @param head
     * @return
     */
    public static Node remove(Node head, int num) {
        //这里的作用是万一开头连续的都是相同的就可以直接删除掉
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
