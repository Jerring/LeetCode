package com.github.jerring.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_00525 {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // 初始时放入一个代表前缀和为 0、下标为 -1 的键值对
        map.put(0, -1);
        int res = 0;
        int s = 0;
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(s)) {
                res = Math.max(res, i - map.get(s));
            } else {
                map.put(s, i);
            }
        }
        return res;
    }
}
