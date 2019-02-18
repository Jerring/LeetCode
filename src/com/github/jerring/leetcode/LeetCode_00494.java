package com.github.jerring.leetcode;

public class LeetCode_00494 {

//    public int findTargetSumWays(int[] nums, int S) {
//        return findTargetSumWays(nums, 0, 0, S);
//    }
//
//    private int findTargetSumWays(int[] nums, int i, int sum, int S) {
//        if (i == nums.length) {
//            return sum == S ? 1 : 0;
//        }
//        return findTargetSumWays(nums, i + 1, sum + nums[i], S) + findTargetSumWays(nums, i + 1, sum - nums[i], S);
//    }

//    public int findTargetSumWays(int[] nums, int S) {
//        int[][] cache = new int[nums.length][2001];
//        for (int[] row : cache) {
//            Arrays.fill(row, -1);
//        }
//        return findTargetSumWays(nums, 0, 0, S, cache);
//    }
//
//    private int findTargetSumWays(int[] nums, int i, int sum, int S, int[][] cache) {
//        if (i == nums.length) {
//            return sum == S ? 1 : 0;
//        }
//        if (cache[i][1000 + sum] == -1) {
//            cache[i][1000 + sum] = findTargetSumWays(nums, i + 1, sum + nums[i], S, cache) + findTargetSumWays(nums, i + 1, sum - nums[i], S, cache);
//        }
//        return cache[i][1000 + sum];
//    }

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || ((S + sum) & 1) == 1) {
            return 0;
        }
        return subsetSum(nums, (S + sum) >> 1);
    }

    private int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = s; i >= num; --i) {
                dp[i] += dp[i - num];
            }
        }
        return dp[s];
    }
}
