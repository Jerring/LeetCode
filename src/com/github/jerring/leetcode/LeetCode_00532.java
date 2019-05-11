package com.github.jerring.leetcode;

import java.util.Arrays;

public class LeetCode_00532 {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        int i = 0, j = 1;
        while (i < n && j < n) {
            int diff = nums[j] - nums[i];
            if (diff < k) {
                ++j;
            } else if (diff > k) {
                ++i;
            } else {
                ++res;
                ++i;
                ++j;
                // 跳过重复
                while (i < n && nums[i] == nums[i - 1]) {
                    ++i;
                }
                while (j < n && nums[j] == nums[j - 1]) {
                    ++j;
                }
            }
            // i 追上 j，j 往后移动
            if (i == j) {
                ++j;
            }
        }
        return res;
    }

//    public int findPairs(int[] nums, int k) {
//        if (k < 0) {
//            return 0;
//        }
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        int res = 0;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (k == 0) {
//                if (entry.getValue() >= 2) {
//                    ++res;
//                }
//            } else {
//                if (map.containsKey(entry.getKey() + k)) {
//                    ++res;
//                }
//            }
//        }
//        return res;
//    }
}
