package com.github.jerring.leetcode;

public class LeetCode_00343 {

//    public int integerBreak(int n) {
//        int[] dp = new int[n + 1];
//        int half = n >> 1;
//        for (int i = 1; i <= half; ++i) {
//            for (int j = i; i + j <= n; ++j) {
//                dp[i + j] = Math.max(dp[i + j], Math.max(i, dp[i]) * Math.max(j, dp[j]));
//            }
//        }
//        return dp[n];
//    }

    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        res *= n;
        return res;
    }
}
