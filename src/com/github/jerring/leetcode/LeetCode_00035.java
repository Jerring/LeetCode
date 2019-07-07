package com.github.jerring.leetcode;

public class LeetCode_00035 {

//    public int searchInsert(int[] nums, int target) {
//        int lo = 0;
//        int hi = nums.length;
//        // 插入点的范围在 [0, nums.length] 中。lo == hi 时，lo 就是插入点。
//        while (lo < hi) {
//            int mid = lo + (hi - lo) / 2;
//            if (target > nums[mid]) {
//                lo = mid + 1;           // 插入点所在区间不包含 mid
//            } else if (target < nums[mid]) {
//                hi = mid;               // 插入点所在区间包含 mid
//            } else {
//                return mid;
//            }
//        }
//        return lo;
//    }

//    public int searchInsert(int[] nums, int target) {
//        for (int i = 0; i < nums.length; ++i) {
//            if (nums[i] >= target) {
//                return i;
//            }
//        }
//        return nums.length;
//    }

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + r >>> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return r;
    }
}
