package com.github.jerring.leetcode;

public class LeetCode_00209 {

    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0, r = 0;   // [l, r) 为可能的连续子数组
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r++];
            while (sum >= s) {
                res = Math.min(res, r - l);
                sum -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

//    public int minSubArrayLen(int s, int[] nums) {
//        int res = Integer.MAX_VALUE;
//        int n = nums.length;
//        int[] sum = new int[n + 1];
//        for (int i = 1; i <= n; ++i) {
//            sum[i] = sum[i - 1] + nums[i - 1];
//        }
//        for (int i = 1; i <= n; ++i) {
//            int index = Arrays.binarySearch(sum, sum[i - 1] + s);
//            if (index < 0) {
//                index = -(index + 1);
//            }
//            if (index != sum.length) {
//                res = Math.min(res, index - i + 1);
//            }
//        }
//        return res == Integer.MAX_VALUE ? 0 : res;
//    }
}
