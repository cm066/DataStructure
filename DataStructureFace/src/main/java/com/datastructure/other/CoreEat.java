package com.datastructure.other;


/**
 * 羊吃草的问题
 */
public class CoreEat {

    /**
     * n份草放在一堆
     * 先手后手都绝顶聪明
     * string ”先手“ ”后手“
     *
     * @param n
     * @return
     */
    public static String winner1(int n) {

        // 0，1，2，3，4
        if (n < 5) {
            return (n == 0 || n == 2) ? "后手" : "先手";
        }
        int base = 1;//先手决定吃草
        while (base <= n) {
            if (winner1(n - base).equals("后手")) {
                return "先手";
            }
            if (base > n / 4) { //防溢出
                break;
            }
            base *= 4;

        }
        return "后手";
    }

    public static String winner2(int n) {
        if (n % 5 == 0 || n % 5 == 2) {
            return "后手";
        } else {
            return "先手";
        }
    }
}
