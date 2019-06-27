package com.github.jerring.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_00560 {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 初始时放入一个代表前缀和为 0 出现过 1 次的键值对
        map.put(0, 1);
        int res = 0;
        int s = 0;
        for (int num : nums) {
            s += num;
            res += map.getOrDefault(s - k, 0);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return res;
    }
}
