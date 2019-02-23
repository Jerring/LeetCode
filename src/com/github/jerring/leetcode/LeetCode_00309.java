package com.github.jerring.leetcode;

public class LeetCode_00309 {

//    public int maxProfit(int[] prices) {
//        if (prices == null || prices.length <= 1) {
//            return 0;
//        }
//        int[] sell = new int[prices.length];
//        int[] buy = new int[prices.length];
//        sell[0] = 0;
//        buy[0] = -prices[0];
//        for (int i = 1; i < prices.length; ++i) {
//            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
//            buy[i] = Math.max(buy[i - 1], (i >= 2 ? sell[i - 2] : 0) - prices[i]);
//        }
//        return sell[prices.length - 1];
//    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int curSell = 0;
        int preSell = 0;
        int buy = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            int tmp = curSell;
            curSell = Math.max(curSell, buy + prices[i]);
            buy = Math.max(buy, preSell - prices[i]);
            preSell = tmp;
        }
        return curSell;
    }
}
