package com.github.jerring.leetcode;

import java.util.Arrays;

public class LeetCode_00300 {

//    public int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int n = nums.length;
//        int[] dp = new int[n];
//        for (int i = 0; i < n; ++i) {
//            dp[i] = 1;
//            for (int j = 0; j < i; ++j) {
//                if (nums[i] > nums[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//        }
//        int res = dp[0];
//        for (int d : dp) {
//            res = Math.max(res, d);
//        }
//        return res;
//    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            // 找到第一个大于等于 num 的位置
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                ++len;
            }
        }
        return len;
    }
}
