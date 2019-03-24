package com.github.jerring.leetcode;

public class LeetCode_00477 {

//    public int totalHammingDistance(int[] nums) {
//        int sum = 0;
//        for (int i = 0; i < nums.length; ++i) {
//            for (int j = i + 1; j < nums.length; ++j) {
//                sum += Integer.bitCount(nums[i] ^ nums[j]);
//            }
//        }
//        return sum;
//    }

    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < 31; ++i) {
            int cnt = 0;
            for (int num : nums) {
                cnt += (num >> i) & 1;
            }
            sum += cnt * (nums.length - cnt);
        }
        return sum;
    }
}
