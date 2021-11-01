package com.niukelearn;

import java.util.Arrays;

/**
 * @author cm
 * @create 2021/10/18-11:38 下午
 * 牛牛有一些排成一行的正方形。每个正方形已经被染成红色或者绿色。
 * 牛牛现在可 以选择任意一个正方形然后用这两种颜色的任意一种进行染色,这个正方形的颜色将 会被覆盖。牛牛的目标是在完成染色之后,
 * 每个红色R都比每个绿色G距离最左侧近。 牛牛想知道他最少需要涂染几个正方形。
 *  输入
 * RRGGG
 * 输出
 * 0
 */
public class MinPaint {
    public static void main(String[] args) {
        String s = "RGGGR";
        int i = minPaint(s);
        System.out.println(i);
    }
    public static int minPaint(String s) {
        if (s == null || s.length() < 2){
            return 0;
        }
        char[] str = s.toCharArray();
        //求出每个G右边有多少个R
        int[] right = new int[str.length];
        right[str.length -1] = str[str.length-1] == 'R' ? 1:0;
        for (int i = str.length -2; i >= 0 ; i--) {
            right[i] = right[i+1] + (str[i] == 'R' ? 1:0);
        }
        //[2, 1, 1, 1, 1]
        System.out.println(Arrays.toString(right));
        int res = right[0];
        int left = 0;
        for (int i = 0; i < str.length-1; i++) {
                left += str[i] == 'G'?1:0;
            res = Math.min(res,left+right[i+1]);
        }
        res = Math.min(res, left + (str[str.length - 1] == 'G' ? 1 : 0));
        return res;
    }
}
