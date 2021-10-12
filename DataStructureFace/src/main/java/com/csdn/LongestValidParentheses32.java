package com.csdn;


import java.util.Stack;

/**
 *给⼀个⼀堆括号的字符串，然后返回最⻓的合法的括号的⻓度
 * 简单点来说就是判断有几对括号是合法的
 * todo
 */
public class LongestValidParentheses32 {

    public static void main(String[] args) {
        String s = "((()))";
        int i = longestValidParentheses(s);
        System.out.println(i);
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else if (!stack.isEmpty() && s.charAt(i) == ')'){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 第一种方法采用暴力的方法来解
     * 列举出所有的可能性
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+2; j <= s.length(); j +=2) {
                if (isValid(s.substring(i,j))){
                    maxLen = Math.max(maxLen, j -i);
                }
            }
        }
        return maxLen;
    }
}
