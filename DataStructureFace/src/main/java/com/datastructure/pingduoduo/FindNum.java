package com.datastructure.pingduoduo;


/**
 * 定义为：每个数组的十进制表示中（0-9），每个数位各不相同且个位数之和等于N
 * 满足条件的数字可能很多，找到其中的最小值即可
 */
public class FindNum {

    public static void main(String[] args) {
        System.out.println(findNum(18));
    }

    public static int findNum(int num) {
        if (num > 45) {
            return -1;
        }
        if (num < 10) {
            return num;
        }
        int res = 0;
        int digit = 0;//这个用于进位用的
        for (int i = 9; i > 0; i--) {
            if (num != 0 && i <= num) {
                num -= i;
                res += (int) Math.pow(10, digit) * i;
                digit++;
            }
        }
        return res;
    }
}
