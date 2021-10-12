package com.csdn;


/**
 * 将一个整数反正 例如123 -》321 -123 -》-321
 */
public class IntReverse {
    public static void main(String[] args) {
        int x = -153423646;
        int reverse = reverse(x);
        System.out.println(reverse);
    }

    /**
     * 还有一种就是和用long来装
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int res = 0;
        while (x != 0 && (x * 10) / 10 == x) {
            /**
             * 这里可能出现越界问题
             */
            int pop = x % 10;
            x = x / 10;
            res = res * 10 + pop;
        }
        return res;
    }
}
