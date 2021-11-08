package com.day20;

/**
 * @author cm
 * @create 2021/11/8-9:58 下午
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *  
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s2 = "s'teL ekat edoCteeL tsetnoc";
        String s3 = "s'teL ekat edoCteeL tsetnoc";
        System.out.println(s2 == s3);
        String s = "Let's take LeetCode contest";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }
    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            char[] chars = s1[i].toCharArray();
            reverseString(chars);
            if (i != s1.length-1){
                builder.append(chars).append(" ");
            }else {
                builder.append(chars);
            }
        }
        return builder.toString();
    }
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left < right){
            if (s[left] != s[right]){
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
            }
            left++;
            right--;
        }
    }
}
