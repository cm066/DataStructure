package com.datastructure.string;

import java.util.Arrays;


/**
 * kmp算法是解决一个长的字符串里面是否包含一个短的字符串，若包含就返回第一个字符出现的下标，反之则返回-1
 */
public class KmpString {
    public static void main(String[] args) {

        String str1 = "BBCABCDABABCDABCDABDE";
        String dest = "ABCDABD";
        int[] next = kmpNext(dest);
        System.out.println(Arrays.toString(next));
        int i = kmpString(str1, dest, next);
        System.out.println(i);
    }

    public static int kmpString(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && (str1.charAt(i) != str2.charAt(j))) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && (dest.charAt(i) != dest.charAt(j))) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
