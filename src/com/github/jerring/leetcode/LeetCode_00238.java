package com.github.jerring.leetcode;

public class LeetCode_00238 {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        // output[i] 为 i 左边的数的乘积
        int p = 1;
        for (int i = 0; i < len; ++i) {
            output[i] = p;
            p *= nums[i];
        }
        // output[i] 乘以 i 右边的数的乘积
        p = 1;
        for (int i = len - 1; i >= 0; --i) {
            output[i] *= p;
            p *= nums[i];
        }
        return output;
    }
}
