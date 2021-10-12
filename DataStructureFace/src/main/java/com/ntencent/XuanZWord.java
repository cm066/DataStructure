package com.ntencent;

/**
 * @author cm
 * @create 2021/9/28-8:14 下午
 *
 * 判断一个词是否是另外一个词的旋转词
 */
public class XuanZWord {

    /**
     * 解题的思路，将第一个词和自己拼接起来，如果另外一个是它的子串（可以用kmp动态规划算法来求解），
     * 那么他们两个是旋转词，否则就不是旋转词
     * @return 是旋转词就返回true，否则就返回false
     */
    public static boolean  isXZWord(String str1,String str2){
        boolean flag =false;
        String str3 = str1 + str1;
        int[] next = getNext(str3);
        for (int i = 0,j=0; i < str3.length(); i++) {
            while (j  >0 && (str3.charAt(i) != str2.charAt(j))){
                j = next[j -1];
            }
            if (str3.charAt(i) == str2.charAt(j)){
                j++;
            }
            if (j == str2.length()) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     *  这个数组就是找出重复的，优化暴力递归中哪次遇到相同的就要重头开始
     * @param str 原始字符串
     * @return 返回一个数组
     */
    public static int[] getNext(String str){
        int[] next = new int[str.length()];
        next[0] = 0;
        for (int i = 1,j=0; i < str.length(); i++) {
            while (j > 0 && (str.charAt(i) != str.charAt(j))){
                j = next[j-1];
            }
            if (str.charAt(i) == str.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    public static void main(String[] args) {
        String s = "12345";
        String s1 = "34512";
        boolean word = isXZWord(s, s1);
        System.out.println(word);
    }
}
