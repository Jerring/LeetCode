package com.github.jerring.leetcode;

public class LeetCode_00704 {

//    public int search(int[] nums, int target) {
//        int l = 0, r = nums.length - 1;
//        while (l <= r) {
//            int mid = l + r >>> 1;
//            if (nums[mid] < target) {
//                l = mid + 1;
//            } else if (nums[mid] > target) {
//                r = mid - 1;
//            } else {
//                return mid;
//            }
//        }
//        return -1;
//    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >>> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return nums[r] == target ? r : -1;
    }
}
