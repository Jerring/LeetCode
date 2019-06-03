package com.github.jerring.leetcode;

public class LeetCode_00268 {

    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res = res ^ (i + 1) ^ nums[i];
        }
        return res;
    }

//    public int missingNumber(int[] nums) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        int n = nums.length;
//        return n * (n + 1) / 2 - sum;
//    }

//    public int missingNumber(int[] nums) {
//        int res = nums.length;
//        for (int i = 0; i < nums.length; ++i) {
//            res += i - nums[i];
//        }
//        return res;
//    }
}
