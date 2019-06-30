package com.github.jerring.leetcode;

import java.util.Arrays;

public class LeetCode_00462 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int k = nums[nums.length / 2];
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - k);
        }
        return res;
    }
}
