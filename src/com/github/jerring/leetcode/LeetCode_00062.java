package com.github.jerring.leetcode;

import java.util.Arrays;

public class LeetCode_00062 {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

//    public int uniquePaths(int m, int n) {
//        int k = Math.min(m, n) - 1;
//        n = m + n - 2;
//        long res = 1;
//        for (int i = 1; i <= k; ++i) {
//            res = res * (n - i + 1) / i;
//        }
//        return (int) res;
//    }
}
