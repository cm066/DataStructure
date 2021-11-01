package com.niukelearn.dp;

/**
 * @author cm
 * @create 2021/10/27-10:07 下午
 */
public class IntegerToString {
    public static void main(String[] args) {
        int n = 102;
        int way = way1(n);
        System.out.println(way);
    }

    public static int way(int num){
        if (num < 1){
            return 0;
        }
        char[] str = String.valueOf(num).toCharArray();
        int N = str.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        dp[N - 1] = str[N - 1] == '0' ? 0 : 1;

        for (int i = N-2; i >=0 ; i--) {
            if (str[i] == '0'){
                dp[i] = 0;
            }else {
                dp[i] = dp[i + 1] + (((str[i] - '0') * 10 + str[i + 1] - '0') < 27 ? dp[i + 2] : 0);
            }
        }
        return dp[0];
    }

    /**
     * 暴力递归解决
     * @param n 输入的参数
     * @return 返回的结果值
     */
    public static int way1(int n){
        if (n <1){
            return 0;
        }
        return process(String.valueOf(n).toCharArray(),0);
    }
    public static int process(char[] str, int index){
        if (index == str.length){
            return 1;
        }
        if (str[index] == '0'){
            return 0;
        }
        int res = process(str,index+1);
        if (index == str.length-1){
            return res;
        }
        if (((str[index]-'0')*10+str[index+1]-'0')<27){
            res += process(str,index+2);
        }
        return res;
    }
}
