package com.github.jerring.leetcode;

import java.util.Arrays;

public class LeetCode_00322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 初始化 dp
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
