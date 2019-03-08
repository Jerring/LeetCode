package com.github.jerring.leetcode;

public class LeetCode_00053 {

    // DP
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            curSum = curSum > 0 ? curSum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

//    // 分治
//    public int maxSubArray(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        return maxSubArray(nums, 0, nums.length - 1);
//    }
//
//    private int maxSubArray(int[] nums, int lo, int hi) {
//        if (lo > hi) {
//            return Integer.MIN_VALUE;
//        }
//        if (lo == hi) {
//            return nums[lo];
//        }
//        // 分解成两个子问题
//        int mid = lo + (hi - lo) / 2;
//        int leftSub = maxSubArray(nums, lo, mid - 1);
//        int rightSub = maxSubArray(nums, mid + 1, hi);
//        int leftSum = 0;
//        int tmp = 0;
//        for (int i = mid - 1; i >= lo; --i) {
//            tmp += nums[i];
//            leftSum = Math.max(leftSum, tmp);
//        }
//        int rightSum = 0;
//        tmp = 0;
//        for (int i = mid + 1; i <= hi; ++i) {
//            tmp += nums[i];
//            rightSum = Math.max(rightSum, tmp);
//        }
//        // 包含 mid 与 不包含 mid 取较大值
//        return Math.max(Math.max(leftSub, rightSub), nums[mid] + leftSum + rightSum);
//    }
}
