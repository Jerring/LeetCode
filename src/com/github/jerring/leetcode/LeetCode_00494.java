package com.github.jerring.leetcode;

public class LeetCode_00494 {

//    // DFS
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
//
//    // 记忆化搜索
//    public int findTargetSumWays(int[] nums, int S) {
//        int[][] cache = new int[nums.length][2001];
//        for (int[] row : cache) {
//            // 运用 -1 表示不存在
//            Arrays.fill(row, -1);
//        }
//        return findTargetSumWays(nums, 0, 0, S, cache);
//    }
//
//    private int findTargetSumWays(int[] nums, int i, int sum, int S, int[][] cache) {
//        if (i == nums.length) {
//            return sum == S ? 1 : 0;
//        }
//        // 加上偏移量 1000 保证下标非负
//        if (cache[i][1000 + sum] == -1) {
//            cache[i][1000 + sum] = findTargetSumWays(nums, i + 1, sum + nums[i], S, cache) + findTargetSumWays(nums, i + 1, sum - nums[i], S, cache);
//        }
//        return cache[i][1000 + sum];
//    }

    // DP（01背包）
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 所有元素加和都达不到目标值或 (S + sum) 为奇数显然不满足条件
        if (sum < S || ((S + sum) & 1) == 1) {
            return 0;
        }
        return subsetSum(nums, (S + sum) >> 1);
    }

    /**
     * 传入一个数组和目标值，返回数组所表示的集合的子集中元素的加和等于目标值的方法总数。
     * 这是一个 01背包 问题（每个元素有选与不选两种选择）。
     * @param nums 数组
     * @param s 目标值
     * @return 子集中元素的加和等于目标值的情况总数
     */
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
