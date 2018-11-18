package com.github.jerring.leetcode;

import java.util.Arrays;

public class LeetCode_00016 {

    public int threeSumClosest(int[] nums, int target) {
        // 首先从小到大排序
        Arrays.sort(nums);
        int n = nums.length;
        // 初始化为任意一个可能值
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n; ++i) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                int diff = sum - target;
                // 如果相等直接返回，不可能有更接近的
                if (diff == 0) {
                    return sum;
                }
                // 更接近就更新
                if (Math.abs(diff) < Math.abs(res - target)) {
                    res = sum;
                }
                if (diff > 0) { // 因为数组有序，说明右侧的数过大，所以下标左移
                    --r;
                } else {        // 因为数组有序，说明左侧的数过小，所以下标右移
                    ++l;
                }
            }
        }
        return res;
    }
}
