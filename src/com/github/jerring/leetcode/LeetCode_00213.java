package com.github.jerring.leetcode;

public class LeetCode_00213 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 取偷窃 [0, nums.length - 2] 与 [1, nums.length - 1] 的较大值
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int begin, int end) {
        int pre2 = 0;
        int pre1 = 0;
        int cur = 0;
        for (int i = begin; i <= end; ++i) {
            cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }
}
