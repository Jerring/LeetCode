package com.github.jerring.leetcode;

public class LeetCode_00055 {

    public boolean canJump(int[] nums) {
        int dis = 0;
        for (int i = 0; i < nums.length && dis >= i; ++i) {
            dis = Math.max(dis, i + nums[i]);
        }
        return dis >= nums.length - 1;
    }
}
