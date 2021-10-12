package com.csdn;


import java.util.Stack;

/**
 * 给定一个只包含括号的字符串，判断这里面的括号是否成对出现对
 */
public class IsValid {

    public static void main(String[] args) {

    }

    /**
     * 采用栈对思想
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c){
                case '(':
                case '[':
                case '{':
                    brackets.push(c);
                    break;
                case ')':
                    if(!brackets.empty()){
                        if(brackets.peek()== '('){
                            brackets.pop();
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                    break;
                case ']':
                    if(!brackets.empty()){
                        if(brackets.peek()=='['){
                            brackets.pop();
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                    break;
                case '}':
                    if(!brackets.empty()){
                        if(brackets.peek()=='{'){
                            brackets.pop();
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
            }
        }
        return brackets.empty();
    }
}
