package com.github.jerring.leetcode;

import java.util.Arrays;

public class LeetCode_00594 {

//    public int findLHS(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        int res = 0;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (map.containsKey(entry.getKey() + 1)) {
//                res = Math.max(res, entry.getValue() + map.get(entry.getKey() + 1));
//            }
//        }
//        return res;
//    }

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int preCount = 0;
        for (int i = 0; i < nums.length; ++i) {
            int count = 1;
            if (i > 0 && nums[i] - nums[i - 1] == 1) {
                while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                    ++count;
                    ++i;
                }
                res = Math.max(res, preCount + count);
            } else {
                while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                    ++count;
                    ++i;
                }
            }
            preCount = count;
        }
        return res;
    }
}
