package com.datastructure.pingduoduo;

import java.util.Arrays;

/**
 * 将两个字符编程一样的
 * 1、交换任意两个相邻的字符，代价为0
 * 2、将任意一个字符a修改成字符b，代价为｜a-b｜
 * 现有两个长度相同的字符串x和y，如果要将x和y变成一样的字符串，需要的最少的代价之和
 */
public class StringB {

    public static void main(String[] args) {
        String b = "abc";
        String b1 = "aca";
        System.out.println(getStringB(b, b1));
    }

    public static int getStringB(String b, String b1) {
        int res = 0;
        if (b.equals(b1)) {//直接先判断两个是否相等，如果相等就不用
            return res;
        }
        char[] ch1 = b.toCharArray();
        char[] ch2 = b1.toCharArray();
        //因为题目中说了两个相邻字符交换的代价为0，所以将两个的字符串进行排序，
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        for (int i = 0; i < b.length(); ++i) {
            if (ch1[i] != ch2[i]) {
                res += (Math.abs(ch1[i] - ch2[i]));
            }
        }
        return res;
    }
}
