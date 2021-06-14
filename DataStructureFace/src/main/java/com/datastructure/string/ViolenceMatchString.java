package com.datastructure.string;


/**
 * 暴力递归解决字符串匹配问题
 */
public class ViolenceMatchString {

    public static void main(String[] args) {
        String str1 = "尚硅谷 尚硅谷你";
        String str2 = "尚硅谷你";
        int i = matchString(str1, str2);
        System.out.println(i);
    }
    public static int matchString(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int str1Len = s1.length;
        int str2Len = s2.length;
        int i = 0;
        int j = 0;
        while (i < str1Len && j < str2Len){
            if (s1[i] == s2[j]){
                i++;
                j++;
            }else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == str2Len){
            return i - j;
        }else {
            return -1;
        }
    }
}
