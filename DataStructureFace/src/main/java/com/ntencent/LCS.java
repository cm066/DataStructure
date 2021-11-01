package com.ntencent;

/**
 * @author cm
 * @create 2021/10/14-10:40 下午
 *
 * 阿里 最长公共子序列-II 输入：
 * "1A2C3D4B56","B1D23A456A"
 * 复制
 * 返回值：
 * "123456"
 */
public class LCS {
    public static void main(String[] args) {

    }
    /**
     * longest common subsequence
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String s1, String s2) {
        if (s1 == null || s2 == null){
            return "-1";
        }

        return "0";
    }
}
