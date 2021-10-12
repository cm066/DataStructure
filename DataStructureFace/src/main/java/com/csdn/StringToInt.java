package com.csdn;

public class StringToInt {

    public static void main(String[] args) {
//        char c = ' ';
//        boolean b = false;
////        if (c == ' '){
////            b = true;
////        }
//        char c = '0';
//        if (c < '-'){
//            b = true;
//        }

//        System.out.println(b);
//        System.out.println(b);
        System.out.println(Integer.MIN_VALUE);
        String s = "a-2147483649ada2323";
        int i = myAtoi(s);
        System.out.println(i);
    }

    public static int myAtoi(String str) {
        long res = 0;
        StringBuilder builder = new StringBuilder();
        boolean flag = true;//判断是否是出现数字或者是符号之前出现的空格
        boolean b = false;//代表不是负数
        char c = str.charAt(0);
        if (c == '-' || c == '+' || c == ' ' || (c >= '0' && c <= '9')) {
            if (c != ' ') {
                if (c >= '0' && c <= '9') {
                    builder.append(c);
                }
                if (c == '-') {
                    b = true;
                }
                flag = false;
            }

        } else {
            return 0;
        }

        for (int i = 1; i < str.length(); i++) {
            char c1 = str.charAt(i);
            if (c1 < '0' || c1 > '9') {
                break;
            }
            builder.append(c1);
        }
        System.out.println(builder.toString());
        res = Long.parseLong(builder.toString());
        if (b) {
            res = -res;
        }
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) res;
        }
    }
}
