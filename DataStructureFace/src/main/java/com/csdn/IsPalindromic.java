package com.csdn;


/**
 * 判断是否是回文字符串，并且返回最长的回文串
 */
public class IsPalindromic {


    public static void main(String[] args) {
        String s = "abac";
        StringBuffer stringBuffer = new StringBuffer(s);
        String s2 = stringBuffer.reverse().toString();
        String length = getLCSLength1(s, s2);
        System.out.println(length);
        String s1 = longestPalindrome1(s);
        System.out.println(s1);
    }
    // 暴⼒解法

    /**
     * 这样做的时间复杂度为0（n三次方）
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());//这里比较那个大
                }
            }
        }
        return ans;
    }

    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取两个字符串最长公共子串长度
     *
     * @param str  第一个字符串
     * @param str2 第二个字符串
     * @return 如果存在则返回最长公共子串长度，否则返回0
     */
    public static String getLCSLength(String str, String str2) {
        char[] arr = str.toCharArray();
        char[] arr2 = str2.toCharArray();
        int[][] temp = new int[arr.length][arr2.length];    //声明一个二维数组，存储最长公共子串长度
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr[i] == arr2[j]) {
                    if (i == 0 || j == 0) {
                        temp[i][j] = 1;
                    } else {
                        temp[i][j] = temp[i - 1][j - 1] + 1;
                    }
                }
                if (temp[i][j] > maxLen) {
                    int beforeRev = str.length() - 1 - j;
                    if (beforeRev + temp[i][j] - 1 == i) {
                        maxLen = temp[i][j];
                        maxEnd = i;
                    }
                }
            }
        }
        return str.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }


    /**
     * 优化空间复杂度，其实我们只需要记住上一次的结果即可，上上次的结果对我们来说没有什么作用
     *
     * @param str
     * @param str2
     * @return
     */
    public static String getLCSLength1(String str, String str2) {
        char[] arr = str.toCharArray();
        char[] arr2 = str2.toCharArray();
//        int[][] temp = new int[arr.length][arr2.length];    //声明一个二维数组，存储最长公共子串长度
        int[] temp = new int[arr.length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                if (arr[i] == arr2[j]) {

                    if (i == 0 || j == 0) {
                        temp[j] = 1;
                    } else {
//                        temp[i][j] = temp[i-1][j-1]+1;
                        temp[j] = temp[j - 1] + 1;
                    }
                }
                if (temp[j] > maxLen) {
                    int beforeRev = str.length() - 1 - j;
                    if (beforeRev + temp[j] - 1 == i) {
                        maxLen = temp[j];
                        maxEnd = i;
                    }
                }
//                if (temp[i][j] > maxLen){
//                    int beforeRev = str.length() - 1 - j;
//                    if (beforeRev + temp[i][j] - 1 == i){
//                        maxLen = temp[i][j];
//                        maxEnd = i;
//                    }
//                }
            }
        }
        return str.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    /**
     * 中心扩散法来扩散
     *
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 0;
        // 数组第一位记录起始位置，第二位记录长度
        int[] res = new int[2];
        for (int i = 0; i < s.length() - 1; i++) {
            int[] odd = centerSpread(s, i, i);//奇数个的情况
            int[] even = centerSpread(s, i, i + 1);//偶数个的情况
            int[] max = odd[1] > even[1] ? odd : even;
            if (max[1] > maxLen) {
                res = max;
                maxLen = max[1];
            }
        }
        return s.substring(res[0], res[1] + res[0]);
    }

    private static int[] centerSpread(String s, int left, int right) {
        int len = s.length();
        while (left >= 0 && right < len) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right - left - 1};
    }


    public static String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++)
            ret += "#" + s.charAt(i);
        ret += "#$";
        return ret;
    }

    // ⻢拉⻋算法

    /**
     * 时间复杂度为o(n），利用回文串中心对称的原理
     * @param s
     * @return
     */
//    public static String longestPalindrome(String s) {
//        int n = T.length();
//        int[] P = new int[n];
//        int C = 0, R = 0;
//    }
}
