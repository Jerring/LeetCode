package com.github.jerring.leetcode;

public class LeetCode_00416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 和为奇数显然不可能
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; --i) {
                dp[i] = dp[i] || dp[i - num];
                if (dp[sum]) {
                    return true;
                }
            }
        }
        return false;
    }

//    public boolean canPartition(int[] nums) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        if ((sum & 1) == 1) {
//            return false;
//        }
//        return helper(nums, nums.length - 1, sum / 2);
//    }
//
//    private boolean helper(int[] nums, int i, int sum) {
//        if (sum == 0) {
//            return true;
//        }
//        // 加上 sum < nums[i] 这个限制条件剪枝，否则容易超时
//        if (sum < 0 || i < 0 || sum < nums[i]) {
//            return false;
//        }
//        return helper(nums, i - 1, sum - nums[i]) || helper(nums, i - 1, sum);
//    }
}
