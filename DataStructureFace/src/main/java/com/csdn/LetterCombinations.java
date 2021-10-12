package com.csdn;


import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给⼀串数字，每个数可以代表数字键下的⼏个字⺟，返回这些数字下的字⺟的所有组成可能。
 */
public class LetterCombinations {
    public static void main(String[] args) {
        String digitLetter[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
                "tuv", "wxyz" };
        String s = "34";
        List<String> strings = letterCombinations2(s);
        System.out.println(strings);

    }


    /**
     * 采用队列的方式来实现
     * @param digits
     * @return
     */
    public static List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i){
                String t = ans.remove();
                for (char s : mapping[x].toCharArray()) {
                    ans.add(s+t);
                }
            }
        }
        return ans;
    }
    /**
     * 可以取出
     * @param digits
     * @return
     */
    public static List<String> letterCombinations1(String digits) {
        List<String> ans = new ArrayList<String>();
        String digitLetter[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
                "tuv", "wxyz" };
        int[] nums = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            nums[i] = digits.charAt(i) - '0';
        }
        for (int i = 0; i < nums.length; i++) {
            String s = digitLetter[nums[i]];
            for (int j = i+1; j < nums.length; j++) {
                String s1 = digitLetter[nums[j]];
                for (int k = 0; k < s.length(); k++) {
                    for (int l = 0; l < s1.length(); l++) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(s.charAt(k));
                        builder.append(s1.charAt(l));
                        ans.add(builder.toString());
                    }
                }
            }
        }
        return ans;
    }
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < digits.length(); i++) {
            ans = mul(ans, getList(digits.charAt(i) - '0'));
        }
        return ans;
    }
    public static List<String> getList(int digit) {
        String digitLetter[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
                "tuv", "wxyz" };
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < digitLetter[digit].length(); i++) {
            ans.add(digitLetter[digit].charAt(i) + "");
        }
        return ans; }
    //定义成两个 List 相乘
    public static List<String> mul(List<String> l1, List<String> l2) {
        if (l1.size() != 0 && l2.size() == 0) {
            return l1;
        }
        if (l1.size() == 0 && l2.size() != 0) {
            return l2;
        }
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < l1.size(); i++)
            for (int j = 0; j < l2.size(); j++) {
                ans.add(l1.get(i) + l2.get(j));
            }
        return ans;
    }
}
