package com.github.jerring.leetcode;

public class LeetCode_00033 {

//    public int search(int[] nums, int target) {
//        int lo = 0;
//        int hi = nums.length - 1;
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            if (target == nums[mid]) {
//                return mid;
//            }
//            if (nums[lo] <= nums[mid]) {    // lo 和 mid 在同一边
//                if (target >= nums[lo] && target < nums[mid]) {
//                    hi = mid - 1;
//                } else {
//                    lo = mid + 1;
//                }
//            } else {                        // lo 和 mid 不在同一边
//                if (target > nums[mid] && target <= nums[hi]) {
//                    lo = mid + 1;
//                } else {
//                    hi = mid - 1;
//                }
//            }
//        }
//        return -1;
//    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        if (nums[l] > nums[r]) {
            while (l < r) {
                int mid = l + r + 1 >>> 1;
                if (nums[mid] >= nums[0]) l = mid;
                else r = mid - 1;
            }
            if (nums[r] < target) {
                return -1;
            }
            if (nums[0] > target) {
                l = r + 1;
                r = nums.length - 1;
            } else {
                l = 0;
            }
        }
        while (l < r) {
            int mid = l + r >>> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return nums[r] == target ? r : -1;
    }
}
