package com.csdn;


import com.datastructure.string.KmpString;

/**
 * 给定两个字符串，判断另外一个字符串是否在另外一个字串中
 * 若存在返回最开始的位置即可
 * 若没有没有则返回-1即可
 */
public class StrStr28 {
    public static void main(String[] args) {
        String hello = "hello";
        String llo = "llo";
        int i = strStr(hello, llo);
        System.out.println(i);
        int[] ints = KmpString.kmpNext(hello);
        int i1 = KmpString.kmpString(hello, llo, ints);
        System.out.println(i1);
    }

    /**
     * String str1 = "BBCABCDABABCDABCDABDE";
     * String dest = "ABCDABD";
     */

    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 0; i < dest.length(); i++) {
            
        }
        return next;
    }
    /**
     * 第一种方法采用暴力递归的方法来，就是遍历所有的
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
                if (j == needle.length()){
                    return i - j +1;
                }
            }else {
                j=0;
                i = i -j;
            }
        }
        return  -1 ;
    }


}
