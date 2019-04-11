package com.github.jerring.leetcode;

public class LeetCode_00080 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int n = 2;
        for (int i = 2; i < nums.length; ++i) {
            if (nums[i] != nums[n - 2]) {
                nums[n++] = nums[i];
            }
        }
        return n;
    }
}
