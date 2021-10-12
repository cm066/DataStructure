package com.ntencent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cm
 * @create 2021/9/14-10:44 下午
 */
public class LRUCacheDemo {

    //构造一个node节点作为数据载体
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
        public Node() {
        }
    }
    class DoubleLikeList<K,V>{
        Node<K,V> head;
        Node<K,V> tail;
        public DoubleLikeList(){
            head = new Node<>();
            tail = new Node<>();
            head.next = tail.next;
            tail.prev = head;
        }

        /**
         * 添加到头
         * @param node
         */
        public void addHead(Node node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        /**
         * 删除节点
         */
        public void removeNode(Node<K,V> node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.next = null;
            node.prev = null;
        }

        /**
         * 得到最后一个节点
         */
        public Node getLastNode(){
            return tail.prev;
        }

    }
    int cacheSize;
    Map<Integer,Node<Integer,Integer>> map;
    DoubleLikeList<Integer,Integer> doubleLikeList;
    public LRUCacheDemo(int cacheSize){
        this.cacheSize = cacheSize;
        map = new ConcurrentHashMap<>(cacheSize);
        doubleLikeList = new DoubleLikeList<>();
    }
    public Node get(int key){
        Node<Integer, Integer> node = map.get(key);
        if (node == null){
            return null;
        }else {
            doubleLikeList.removeNode(node);
            doubleLikeList.addHead(node);
            return node;
        }
    }
    public void put(int key,int value){
        if (map.containsKey(key)){
            Node<Integer, Integer> node1 = map.get(key);
            node1.value = value;
            map.put(key,node1);
            doubleLikeList.removeNode(node1);
            doubleLikeList.addHead(node1);
        }else {
            if (map.size() == cacheSize){
                Node lastNode = doubleLikeList.getLastNode();
                map.remove(lastNode.key);
                doubleLikeList.removeNode(lastNode);
            }
            Node<Integer, Integer> node = new Node<>();
            node.key = key;
            node.value = value;
            map.put(key,node);
            doubleLikeList.addHead(node);
        }

    }
    public static void main(String[] args) {

    }
}
