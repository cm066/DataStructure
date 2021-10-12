package com.datastructure.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 用贪心算法解决广播覆盖地域问题
 */
public class Greed {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> casts = new HashMap<>();
        HashSet<String> k1 = new HashSet<>();
        k1.add("北京");
        k1.add("上海");
        k1.add("天津");
        casts.put("k1", k1);
        HashSet<String> k2 = new HashSet<>();
        k2.add("广州");
        k2.add("北京");
        k2.add("深圳");
        casts.put("k2", k2);
        HashSet<String> k3 = new HashSet<>();
        k3.add("成都");
        k3.add("上海");
        k3.add("杭州");
        casts.put("k3", k3);
        HashSet<String> k4 = new HashSet<>();
        k4.add("上海");
        k4.add("天津");
        casts.put("k4", k4);
        HashSet<String> k5 = new HashSet<>();
        k5.add("杭州");
        k5.add("大连");
        casts.put("k5", k5);
        HashSet<String> all = new HashSet<>();
        all.add("北京");
        all.add("上海");
        all.add("天津");
        all.add("广州");
        all.add("深圳");
        all.add("成都");
        all.add("杭州");
        all.add("大连");

        ArrayList<String> selects = new ArrayList<>();
        HashSet<String> temSet = new HashSet<>();
        String maxKey = null;
        while (all.size() != 0) {

            maxKey = null;
            for (String key : casts.keySet()) {
                temSet.clear();//每次进来之前都需要把之前集合里面都东西给清除掉，不然会一直包含在里面
                HashSet<String> ares = casts.get(key);
                temSet.addAll(ares);
                temSet.retainAll(all);
                if (temSet.size() > 0 && (maxKey == null || temSet.size() > casts.get(maxKey).size())) {
                    maxKey = key;

                }
            }
            if (maxKey != null) {
//                HashSet<String> hashSet = casts.get(maxKey);
                selects.add(maxKey);
                all.removeAll(casts.get(maxKey));
            }

        }
        System.out.println(selects);
    }
}
