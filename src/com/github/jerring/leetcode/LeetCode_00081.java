package com.github.jerring.leetcode;

public class LeetCode_00081 {

    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[lo] < nums[mid]) {         // lo 和 mid 在同一边
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1;
                }
            } else if (nums[lo] > nums[mid]) {  // lo 和 mid 不在同一边
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {                            // 不能判别 lo 和 mid 是否在同一边
                ++lo;
            }
        }
        return false;
    }
}
