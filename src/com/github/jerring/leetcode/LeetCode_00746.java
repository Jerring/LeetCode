package com.github.jerring.leetcode;

public class LeetCode_00746 {

//    public int minCostClimbingStairs(int[] cost) {
//        int n = cost.length;
//        int[] dp = new int[n + 1];
//        for (int i = 2; i <= n; ++i) {
//            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
//        }
//        return dp[n];
//    }

    public int minCostClimbingStairs(int[] cost) {
        int pre1 = 0, pre2 = 0;
        int res = 0;
        for (int i = 2; i <= cost.length; ++i) {
            res = Math.min(pre1 + cost[i - 1], pre2 + cost[i - 2]);
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }
}
