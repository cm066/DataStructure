package com.datastructure.find;


/**
 * 随机给定一个整数，然后转化成二进制，统计二进制数中1的个数
 * todo 找出0的个数
 */
public class FindBitCount {
    public static void main(String[] args) {
        int a = 7;
        int bitCount = findBitCount(a);
        System.out.println(bitCount);
    }

    /**
     * 解题思路
     *  就是二进制运算 然后一直到最右边的1
     * @param N
     * @return
     */
    public static int findBitCount(int N){
        int count = 0;
        while (N != 0){
            int one = N & ((~N) + 1);
            count++;
            N ^=  one;
        }
        return count;
    }
}
