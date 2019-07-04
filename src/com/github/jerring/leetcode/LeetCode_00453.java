package com.github.jerring.leetcode;

import java.util.Arrays;

public class LeetCode_00453 {

    public int minMoves(int[] nums) {
        return Arrays.stream(nums).sum() - Arrays.stream(nums).min().getAsInt() * nums.length;
    }
}
