package com.niukelearn.dp;

/**
 * @author cm
 * @create 2021/10/24-10:35 上午
 *背包问题
 */
public class Back {
    public static void main(String[] args) {
        int[] arr = {1,2,4};
        int i = fuc2(arr, 10);
        System.out.println(i);
    }
    public static int way1(int[] arr,int w){
        return process(arr,0,w);
    }
    public static int process(int[] arr,int index,int rest){
        if (rest < 0){
            return -1;
        }
        if (index == arr.length){
            return 1;
        }
        int next1 = process(arr,index+1,rest);//这个是这个位置不要
        int next2 = process(arr,index+1,rest-arr[index]);//表示当前这个位置需要
        return next1 + (next2>0?next1:0);
    }

    // 根据暴力递归改动态规划
    public static int fuc2(int[] v, int w){
        int len = v.length;
        int[][] dp = new int[len + 1][w + 1];
        // 赋值边界
        for (int j = 0; j <= w; j++){
            dp[len][j] = 1;
        }
        // 普遍情况
        for (int i = len - 1; i >= 0; i--){
            for (int j = 0; j <= w; j++){
                dp[i][j] = (j- v[i] >= 0 ? dp[i + 1][j - v[i]] : 0) + dp[i + 1][j]; // 当前零食要和不要都要考虑
            }
        }
        return dp[0][w];
    }

}
