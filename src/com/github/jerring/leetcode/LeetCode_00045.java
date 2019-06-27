package com.github.jerring.leetcode;

public class LeetCode_00045 {

    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int step = 0;
        int l = 0, r = 0;
        while (l <= r) {
            ++step;
            int maxR = 0;
            for (int i = l; i <= r; ++i) {
                maxR = Math.max(maxR, i + nums[i]);
            }
            if (maxR >= nums.length - 1) {
                return step;
            }
            l = r + 1;
            r = maxR;
        }
        return step;
    }
}
