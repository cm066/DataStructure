package com.csdn;


/**
 * 找几个字符串的最长公共字符串
 */
public class IsSameAtIndex {

    public static void main(String[] args) {
        String[] str = {"leets","leetcode","leet","leeds"};
        String s = longestCommonPrefix(str);
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs.length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {

                if (i == strs.length || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    //递归不断分成两部分
    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft = longestCommonPrefix(strs, l , mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }
    //求两个结果的最⻓公共前缀
    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
}
