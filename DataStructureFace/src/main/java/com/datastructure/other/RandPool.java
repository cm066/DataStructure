package com.datastructure.other;

import java.util.HashMap;
import java.util.Random;

public class RandPool {

    public static class Pool<K>{
        private HashMap<K,Integer> keyIndexMap;
        private HashMap<Integer,K> indexKeyMap;
        private int size;
        public Pool(){
            keyIndexMap = new HashMap<>();
            indexKeyMap = new HashMap<>();
            size = 0;
        }

        public void insert(K key){
            if (!this.keyIndexMap.containsKey(key)){
                this.keyIndexMap.put(key,size);
                this.indexKeyMap.put(size++,key);
            }
        }

        public void delete(K key){
            if (this.keyIndexMap.containsKey(key)){
                int deleteIndex = this.keyIndexMap.get(key);
                int lastIndex = --this.size;
                K lastKey = this.indexKeyMap.get(lastIndex);
                this.keyIndexMap.put(lastKey,deleteIndex);
                this.indexKeyMap.put(deleteIndex,lastKey);
                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);
            }
        }
        public K getRandom(){
            if (this.size == 0){
                return null;
            }
            int randomIndex = (int) (Math.random()*this.size);
            return indexKeyMap.get(randomIndex);
        }
    }
}
