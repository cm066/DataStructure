package com.datastructure.other;


/**
 * 采用分治的思想解决汉诺塔问题
 */
public class HanLuoDa {

    public static void main(String[] args) {
        hanLuo(3, 'A', 'B', 'C');
    }

    public static void hanLuo(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第一步从" + a + "到" + c);
        } else {
            hanLuo(num - 1, a, c, b);
            System.out.println("第" + num + "步从" + a + "到" + c);
            hanLuo(num - 1, b, a, c);
        }
    }
}
