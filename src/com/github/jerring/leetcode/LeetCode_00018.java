package com.github.jerring.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_00018 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            // 避免重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; ++j) {
                // 避免重复
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum > target) {         // 因为数组有序，说明右侧的数过大，所以下标左移
                        --r;
                    } else if (sum < target) {  // 因为数组有序，说明左侧的数过小，所以下标右移
                        ++l;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l++], nums[r--]));
                        // 两侧的下标向中间移动，直到不与之前取出的数相同，避免重复
                        while (l < r && nums[l] == nums[l - 1]) {
                            ++l;
                        }
                        while (l < r && nums[r] == nums[r + 1]) {
                            --r;
                        }
                    }
                }
            }
        }
        return res;
    }
}
