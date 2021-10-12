package com.datastructure.bibi;

import java.util.*;

public class GetFragment {

    public static void main(String[] args) {
        String s = "aaabbaaac";
        getFragment(s);
        System.out.println(getFragment(s));
        System.out.println(getFragment2(s));
    }

    public static int getFragment(String str) {
        int res = 0;
        int[] arr = new int[str.length()];//最大长度就是都没有重复都
        int index = 0;
        char[] chars = str.toCharArray();
        int count = 1;
        int j = 0;
        while (j < chars.length) {
            Character c = chars[j];
            for (int i = j + 1; i < chars.length; i++) {
                if (c == chars[i]) {
                    j++;
                    count++;
                } else {
                    break;
                }
            }
            arr[index++] = count;
            j++;
            count = 1;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                sum += arr[i];
            } else {
                break;
            }
        }
        res = sum / index;
        return res;
    }

    public static int getFragment2(String str) {
        // write code here
        char[] ch = str.toCharArray();
        int count = 1;
        int len = ch.length;
        int i = 0;
        while (i < len) {
            if (i > 0 && ch[i] != ch[i - 1]) {
                count++;
            }
            i++;
        }
        return len / count;
    }
}
