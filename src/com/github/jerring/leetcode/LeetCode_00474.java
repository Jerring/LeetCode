package com.github.jerring.leetcode;

public class LeetCode_00474 {

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        // dp[i][j] 代表遍历到当前字符串时使用i个0和j个1所能组成的最大字符串数量
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {   // 01背包每个物品最多用一次
            int[] nums = count(str);
            for (int i = m; i >= nums[0]; --i) {        // 代表 0 的数量的背包
                for (int j = n; j >= nums[1]; --j) {    // 代表 1 的数量的背包
                    dp[i][j] = Math.max(dp[i][j], dp[i - nums[0]][j - nums[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] count(String str) {
        int[] nums = new int[2];
        for (char c : str.toCharArray()) {
            if (c == '0') {
                ++nums[0];
            } else {
                ++nums[1];
            }
        }
        return nums;
    }
}
