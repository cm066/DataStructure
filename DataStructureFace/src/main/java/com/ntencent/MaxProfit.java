package com.ntencent;

/**
 * @author cm
 * @create 2021/10/12-9:30 下午
 * 股票最大利润
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {1,4,2,5,3,7};
        System.out.println(maxProfit1(prices));
    }
    public int maxProfit (int[] prices) {
        // write code here
        int res = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min,prices[i]);
            res = Math.max(res,prices[i] - min);
        }
        return res;
    }
    public static int maxProfit1 (int[] prices) {
        // write code here
        int res = 0;
        int index = 0;
        for (int i = 1; i < prices.length; i++) {
          if (prices[i] - prices[index]>0){
              res += prices[i] - prices[index];
              index = i;
          }
        }
        return res;
    }
}
