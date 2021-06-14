package com.datastructure.string;


/**
 * 用贪心的思想解决，一个字符串是否是另外一个长字符串的子序列，子序列是可以为不连续的，但是顺序必须是一样的
 * 然后字串必须的连续的，然后求字串采用的是kpm算法，没有采用暴力递归的方法
 */
public class IsSubsequence {
    public static void main(String[] args) {
        String s = "ahbgdc";
        String t = "abcx";
        System.out.println(isSubsequence1(s, t));
    }
    public static boolean isSubsequence(String s, String t) {
        return false;
    }

    //先采用暴力递归的方式来解决
    public static boolean isSubsequence1(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        int i = 0;
        int j = 0;
        while (i < s1.length && j < s2.length){
            if (s1[i] == s2[j]){
                i++;
                j++;
            }else {
                i++;
            }
        }
        if (j == s2.length){
            return true;
        }
        return false;
    }
}
