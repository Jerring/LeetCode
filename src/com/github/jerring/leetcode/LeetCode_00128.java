package com.github.jerring.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_00128 {

//    public int longestConsecutive(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int res = 0;
//        for (int num : nums) {
//            if (!map.containsKey(num)) {
//                int left = map.getOrDefault(num - 1, 0);
//                int right = map.getOrDefault(num + 1, 0);
//                int cur = left + 1 + right;
//                res = Math.max(res, cur);
//                map.put(num, cur);
//                map.put(num - left, cur);
//                map.put(num + right, cur);
//            }
//        }
//        return res;
//    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (set.remove(num)) {
                int pre = num - 1;
                int next = num + 1;
                while (set.remove(pre)) {
                    --pre;
                }
                while (set.remove(next)) {
                    ++next;
                }
                res = Math.max(res, next - pre - 1);
            }
        }
        return res;
    }
}
