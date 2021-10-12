package com.csdn;


/**
 * 问题：有两个字符串str和str2，求出两个字符串中最长公共子串长度。
 * 比如：str=acbcbcef，str2=abcbced，则str和str2的最长公共子串为bcbce，最长公共子串长度为5。
 */
public class CSLength {
    public static void main(String[] args) {
        String s = "acbcbcef";
        String s1 = "abcbced";
        int length = getLCSLength(s, s1);
        System.out.println(length);
    }

    /**
     * 获取两个字符串最长公共子串长度
     *
     * @param str  第一个字符串
     * @param str2 第二个字符串
     * @return 如果存在则返回最长公共子串长度，否则返回0
     */
    public static int getLCSLength(String str, String str2) {
        char[] ary = str.toCharArray();
        char[] ary2 = str2.toCharArray();

        int[][] temp = new int[ary.length][ary2.length];    //声明一个二维数组，存储最长公共子串长度
        int length = 0;    //最长公共子串长度
        for (int i = 0; i < ary.length; i++) {
            for (int j = 0; j < ary2.length; j++) {
                if (ary[i] == ary2[j]) {
                    temp[i][j] = 1;//这里还考虑是第一次还是不是第一次
                    if (i > 0 && j > 0) {
                        temp[i][j] = temp[i - 1][j - 1] + 1;
                        length = Math.max(length, temp[i][j]);
                    }
                }
            }
        }
        return length;
    }
}
