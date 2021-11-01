package com.niukelearn;

/**
 * @author cm
 * @create 2021/10/18-10:21 下午
 * 牛吃青草
 */
public class EatGrace {
    public static void main(String[] args) {
        System.out.println(eat(5));
        System.out.println(eat1(5));
    }
    public static String eat(int n){
        if (n <5){
            if (n == 0 || n == 2){
                return "后手";
            }else {
                return "先手";
            }
        }
        int base = 1;
        while (base <= n){
            if (eat(n-base).equals("后手")){
                return "先手";
            }
            if (base > n /4){
                break;
            }
            base *= 4;
        }
        return "后手";
    }

    public static String eat1(int n){
        if(n %5 ==0 || n %5 ==2){
            return "后手";
        }
        return "先手";
    }
}
