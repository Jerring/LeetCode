package com.github.jerring.leetcode;

public class LeetCode_00154 {

//    public int findMin(int[] nums) {
//        return findMin(nums, 0, nums.length - 1);
//    }
//
//    private int findMin(int[] nums, int lo, int hi) {
//        // 只有一个元素或区间 [lo, hi] 已经有序
//        if (lo == hi || nums[lo] < nums[hi]) {
//            return nums[lo];
//        }
//        int mid = lo + (hi - lo) / 2;
//        return Math.min(findMin(nums, lo, mid), findMin(nums, mid + 1, hi));
//    }

    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        // 最小值的范围在 [0, nums.length - 1] 中。lo == hi 时，lo 就是最小值所在处。
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                --hi;
            }
        }
        return nums[lo];
    }
}
