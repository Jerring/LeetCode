package com.github.jerring.leetcode;

public class LeetCode_00540 {

    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if ((mid & 1) == 1) {
                --mid;
            }
            if (nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }

//    public int singleNonDuplicate(int[] nums) {
//        int res = 0;
//        for (int num : nums) {
//            res ^= num;
//        }
//        return res;
//    }
}
