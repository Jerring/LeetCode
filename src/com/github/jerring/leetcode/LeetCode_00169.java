package com.github.jerring.leetcode;

public class LeetCode_00169 {

    // 摩尔投票算法
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                candidate = num;
            }
            cnt += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

//    // 分治
//    public int majorityElement(int[] nums) {
//        return majorityElement(nums, 0, nums.length - 1);
//    }
//
//    private int majorityElement(int[] nums, int lo, int hi) {
//        if (lo == hi) {
//            return nums[lo];
//        }
//        int mid = lo + (hi - lo) / 2;
//        int left = majorityElement(nums, lo, mid);
//        int right = majorityElement(nums, mid + 1, hi);
//        if (left == right) {
//            return left;
//        }
//        return countRange(left, nums, lo, hi) > countRange(right, nums, lo, hi) ? left : right;
//    }
//
//    private int countRange(int num, int[] nums, int lo, int hi) {
//        int cnt = 0;
//        for (int i = lo; i <= hi; ++i) {
//            if (nums[i] == num) {
//                ++cnt;
//            }
//        }
//        return cnt;
//    }
}
