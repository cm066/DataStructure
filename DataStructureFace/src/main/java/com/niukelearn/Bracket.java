package com.niukelearn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cm
 * @create 2021/10/15-12:31 上午
 * <p>
 * 括号有关的题
 */
public class Bracket {
    public static void main(String[] args) {
//        String s = "))(()())";
//        String s1 = "(())))";
////        int i = maxLength(s);
////        System.out.println(i);
//        boolean full = isFull(s1);
//        System.out.println(full);
        String s = ")(()((((()))))))()()(()(()(())()()()))())(";
        int i = maxLength(s);
        System.out.println(i);
    }

    //1、判断这个括号是否是完整的
    public static boolean isFull(String s) {
        int count = 0;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] != '('  || str[i] != ')'){
                return false;
            }
            if (str[i] == '(') {
                count++;
            }
            if (str[i] == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
    //2、判断这个括号字符串需要增加多少才能成完整的字符串

    public static int needMuch(String s) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            if (s.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    res++;
                }
            }
        }
        return res + count;
    }

    //3、在这个括号字符串中，完整括号最长的是多少 ,还适用于最长无重复字串等问题
    public static int maxLength(String str) {

        if (str == null || str == "") {
            return 0;
        }
        int[] dp = new int[str.length()];
        char[] chars = str.toCharArray();
        int res = 0;
        int pre = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chars[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
                res = Math.max(res, dp[i]);
            }
        }

        return res;
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int res = 0;
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
