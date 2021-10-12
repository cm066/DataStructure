package com.ntencent;


/**
 * @author cm
 * @create 2021/9/13-8:52 下午
 * 牛课网中腾讯的算法题之反转链表
 */
public class ReverseLinke {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 =new Node(2);
        Node n3 = new Node(3);
        n2.next = n3;
        n1.next = n2;
        printNode(n1);
        System.out.println("--------------");
        Node node = reverseNode(n1);
        printNode(node);
    }

    public static void printNode(Node head){
        if (head == null) return;
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static Node reverserLinke(Node head){
        Node rHead = new Node(0);
        while (head != null){
            Node tem = head.next;
            head.next = null;
            Node cur = head;
            if (rHead.next == null){
                rHead.next = cur;
                head = tem;
            }else {
                Node rtmp = rHead.next;
                cur.next = rtmp;
                rHead.next = cur;
                head = tem;
            }
        }
        return rHead.next;
    }
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
}

class Node{
    int val;
    Node next;
    Node(int x) {
        val = x;
    }
}