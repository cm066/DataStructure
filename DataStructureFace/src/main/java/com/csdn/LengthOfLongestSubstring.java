package com.csdn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Handler;

/**
 * 给定⼀个字符串，找到没有重复字符的最⻓⼦串，返回它的⻓度。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "bbbb";
        System.out.println(lengthOfLongestSubstring4(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;//保存当前得到满⾜条件的⼦串的最⼤值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        HashSet<Character> se = new HashSet<>();
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (se.contains(c)) {
                return false;
            }
            se.add(c);
        }
        return true;
    }

    /**
     * 采用滑动窗口的办法来解决，就是整体往后移动，而不要区重复之前走过的
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        int res = 0;
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);//遇到相同的就取出这个字符出现的第一个位置
            }
            res = Math.max(j - i + 1, res);//跟上一次的结果相比，谁大就保留谁
            map.put(s.charAt(j), j + 1);
        }
        return res;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int res = 0;
        int n = s.length();
        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                res = Math.max(res, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }

    public static int lengthOfLongestSubstring4(String s) {
        int res = 0;
        int[] ints = new int[128];
        for (int j = 0, i = 0; j < s.length(); j++) {
            i = Math.max(ints[s.charAt(i)], i);
            res = Math.max(j - i + 1, res);
            ints[s.charAt(j)] = j + 1;
        }
        return res;
    }
}
