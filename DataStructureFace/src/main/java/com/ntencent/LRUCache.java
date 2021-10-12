package com.ntencent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cm
 * @create 2021/9/13-11:18 下午
 * 最近最少使用算法
 */
public class LRUCache<V> {

    /**
     * 容量
     */
    private int capacity = 1024;
    /**
     * Node记录表
     */
    private Map<String, ListNode<String, V>> table = new ConcurrentHashMap<>();
    /**
     * 双向链表头部
     */
    private ListNode<String, V> head;
    /**
     * 双向链表尾部
     */
    private ListNode<String, V> tail;


    public LRUCache(int capacity) {
        this();
        this.capacity = capacity;
    }


    public LRUCache() {
        head = new ListNode<>();
        tail = new ListNode<>();
        //初始化双向量表
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }
    public ListNode<String,V> get(String key){
        ListNode<String, V> node = table.get(key);
        if (node == null){
            return null;
        }else {
            moveToHead(head);
            return node;
        }
    }
    public void put(String key, V value){
        ListNode<String, V> node = table.get(key);
        if (table.size() == capacity){
            table.remove(tail.prev.key);
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
        }
        //没有就新增进来，如果有就替换原来的值
        if (node == null){
            node = new ListNode<>();
            node.key = key;
            node.value = value;
            table.put(key, node);
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }else {
            node.value = value;
            moveToHead(node);
        }

    }
    public void moveToHead(ListNode node){
        if (node == head.next) return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        //移动节点到表头
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        //存在缓存表
    }
    public void print(){
        table.forEach((key, value) -> {
            System.out.println("key=" + key + ",value=" + value);
        });
    }

    public static void main(String[] args) {
        LRUCache<ListNode> cache = new LRUCache<>(4);
        ListNode<String, Integer> node1 = new ListNode<>("key1", 1);
        ListNode<String, Integer> node2 = new ListNode<>("key2", 2);
        ListNode<String, Integer> node3 = new ListNode<>("key3", 3);
        ListNode<String, Integer> node4 = new ListNode<>("key4", 4);
        ListNode<String, Integer> node5 = new ListNode<>("key5", 5);
        cache.put("key1", node1);
        cache.put("key2", node2);
        cache.put("key3", node3);
        cache.put("key4", node4);
        cache.print();
        System.out.println("-----------------");
        cache.put("key5",node5);
        cache.print();
    }

}
/**
 * 双向链表类
 */
 class ListNode<K, V> {
     K key;
     V value;
    ListNode<K, V> prev;
    ListNode<K, V> next;

    public ListNode(K key, V value) {
        this.key = key;
        this.value = value;
    }


    public ListNode() {
    }
}