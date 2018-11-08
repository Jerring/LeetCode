package com.github.jerring.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_00001 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int t = target - nums[i];
            if (map.containsKey(t)) {
                return new int[] {map.get(t), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
