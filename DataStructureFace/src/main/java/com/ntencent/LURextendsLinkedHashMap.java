package com.ntencent;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author cm
 * @create 2021/9/14-10:30 下午
 */
public class LURextendsLinkedHashMap<K,V> extends LinkedHashMap<K,V> {
    private int capacity;
    public LURextendsLinkedHashMap(int capacity){
        /**
         *   initialCapacity – the initial capacity
         *         loadFactor – the load factor
         *         accessOrder – the ordering mode - true for access-order,
         *         false for insertion-order
         */

        super(capacity,0.75F,true);
        this.capacity =capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LURextendsLinkedHashMap<String, String> cache = new LURextendsLinkedHashMap<>(3);

    }
}
