package com.github.jerring.leetcode;

public class LeetCode_01155 {

//    public int numRollsToTarget(int d, int f, int target) {
//        int[][] dp = new int[d + 1][target + 1];
//        dp[0][0] = 1;
//        for (int i = 1; i <= d; ++i) {
//            for (int j = 1; j <= target; ++j) {
//                for (int k = 1; k <= f && k <= j; ++k) {
//                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % 1000000007;
//                }
//            }
//        }
//        return dp[d][target];
//    }

//    public int numRollsToTarget(int d, int f, int target) {
//        int[][] dp = new int[d + 1][target + 1];
//        dp[0][0] = 1;
//        for (int i = 1; i <= d; ++i) {
//            for (int j = 1; j <= target; ++j) {
//                // j 大于当前所有骰子的最大和，不可能满足条件
//                if (j > i * f) {
//                    break;
//                }
//                for (int k = 1; k <= f && k <= j; ++k) {
//                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % 1000000007;
//                }
//            }
//        }
//        return dp[d][target];
//    }

    public int numRollsToTarget(int d, int f, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= d; ++i) {
            int[] next = new int[target + 1];
            for (int j = 1; j <= target; ++j) {
                // j 大于当前所有骰子的最大和，不可能满足条件
                if (j > i * f) {
                    break;
                }
                for (int k = 1; k <= f && k <= j; ++k) {
                    next[j] = (next[j] + dp[j - k]) % 1000000007;
                }
            }
            dp = next;
        }
        return dp[target];
    }
}

