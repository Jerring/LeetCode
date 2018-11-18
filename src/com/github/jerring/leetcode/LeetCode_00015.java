package com.github.jerring.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_00015 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        // 首先从小到大排序
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            // 第一个数大于 0，后面的两个数都大于或等于第一个数，从此三数之和肯定大于 0，直接退出
            if (nums[i] > 0) {
                break;
            }
            // 让第一个数不同，避免重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {          // 因为数组有序，说明右侧的数过大，所以下标左移
                    --r;
                } else if (sum < 0) {   // 因为数组有序，说明左侧的数过小，所以下标右移
                    ++l;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    // 两侧的下标向中间移动，直到不与之前取出的数字相同，避免出现重复的三元组
                    while (l < r && nums[l] == nums[l - 1]) {
                        ++l;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        --r;
                    }
                }
            }
        }
        return res;
    }
}
