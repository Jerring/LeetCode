package com.github.jerring.leetcode;

public class LeetCode_00287 {

    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }

//    public int findDuplicate(int[] nums) {
//        int l = 1, r = nums.length - 1;
//        while (l < r) {
//            int mid = l + r >>> 1;
//            int cnt = 0;
//            for (int num : nums) {
//                if (num >= l && num <= mid) {
//                    ++cnt;
//                }
//            }
//            if (cnt > mid - l + 1) r = mid;
//            else l = mid + 1;
//        }
//        return r;
//    }
}
