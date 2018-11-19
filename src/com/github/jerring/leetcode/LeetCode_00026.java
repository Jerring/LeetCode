package com.github.jerring.leetcode;

public class LeetCode_00026 {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

//    public int removeElement(int[] nums, int val) {
//        int n = nums.length;
//        for (int i = 0; i < n; ) {
//            if (nums[i] == val) {
//                nums[i] = nums[--n];
//            } else {
//                ++i;
//            }
//        }
//        return n;
//    }
}
