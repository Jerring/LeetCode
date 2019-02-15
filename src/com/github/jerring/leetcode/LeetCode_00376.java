package com.github.jerring.leetcode;

public class LeetCode_00376 {

//    public int wiggleMaxLength(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        return Math.max(wiggle(nums, true), wiggle(nums, false));
//    }
//
//    private int wiggle(int[] nums, boolean flag) {
//        int res = 1;
//        for (int i = 1; i < nums.length; ++i) {
//            if (flag) {
//                if (nums[i] > nums[i - 1]) {
//                    ++res;
//                    flag = false;
//                }
//            } else {
//                if (nums[i] < nums[i - 1]) {
//                    ++res;
//                    flag = true;
//                }
//            }
//        }
//        return res;
//    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
