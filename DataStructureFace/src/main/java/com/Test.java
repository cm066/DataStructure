package com;

import org.openjdk.jol.vm.VM;

import java.util.*;

/**
 * @author cm
 * @create 2021/10/23-10:57 下午
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(VM.current().details());
    }

    public static Map.Entry[] getSortedHashtableByValue(Map map) {
        Set set = map.entrySet();
        Map.Entry[] entries = (Map.Entry[]) set.toArray(new Map.Entry[set.size()]);
        Arrays.sort(entries, new Comparator() {
            @Override
            public int compare(Object arg0, Object arg1) {
                Long key1 = Long.valueOf(((Map.Entry) arg0).getValue().toString());
                Long key2 = Long.valueOf(((Map.Entry) arg1).getValue().toString());
                return key1.compareTo(key2);
            }
        });
        return entries;
    }
}
