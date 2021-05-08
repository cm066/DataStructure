package com.datastructure.find;


/**
 * 找出一个整数的二进制数的最右侧的那个1
 * 例如 00010010100
 * 变成 00000000100
 */
public class Find1 {

    public static void main(String[] args) {
        int a = 7;
        int i = find1(a);
        System.out.println(i);
    }

    /**
     * 解题思路
     *  这道题其实有两种解法，第一种就是把这个数转化为二进制数，然后把二进制数放进数组，倒序遍历这个数组
     *  然后记录第一次出现1的位置即可
     *  解法2 ：用自己本身与本身取反+1即可
     * @param i
     * @return
     */
    public static int find1(int i){
        int a = i&(~i + 1);
        return a;
    }
}
