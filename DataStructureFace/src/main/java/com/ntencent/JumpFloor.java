package com.ntencent;

/**
 * @author cm
 * @create 2021/9/25-10:10 下午
 * 跳楼梯，一次可以跳一级或者是两级
 */
public class JumpFloor {

    public static int jumpFloor(int target) {
        if (target <= 1){
            return 1;
        }else {
            return jumpFloor(target-1)+jumpFloor(target-2);
        }
    }

    public static int JumpFloor1(int target) {
        int a = 1,b=1;
        for (int i = 2; i <= target; i++) {
            a = a + b;
            b = a - b;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(jumpFloor(10));
        System.out.println(JumpFloor1(10));
    }
}
