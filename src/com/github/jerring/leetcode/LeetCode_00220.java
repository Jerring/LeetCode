package com.github.jerring.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_00220 {

//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        TreeSet<Long> set = new TreeSet<>();
//        for (int i = 0; i < nums.length; ++i) {
//            Long cur = set.ceiling((long) nums[i] - t);
//            if (cur != null && cur <= (long) nums[i] + t) {
//                return true;
//            }
//            set.add((long) nums[i]);
//            if (set.size() > k) {
//                set.remove((long) nums[i - k]);
//            }
//        }
//        return false;
//    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        // 桶的大小 1L + t，桶内元素差值必然不超过 t
        long w = 1L + t;
        // 构建桶
        Map<Long, Long> bucket = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            // 得到桶 id
            long id = getId(nums[i], w);
            if (bucket.containsKey(id) ||   // 同一个桶的元素差值必然不超过 t
                    bucket.containsKey(id - 1) && nums[i] - bucket.get(id - 1) <= t ||  // 前面一个桶二者差值不超过 t
                    bucket.containsKey(id + 1) && bucket.get(id + 1) - nums[i] <= t) {  // 后面一个桶二者差值不超过 t
                return true;
            }
            // 维持窗口大小不超过 k
            if (bucket.size() == k) {
                bucket.remove(getId(nums[i - k], w));
            }
            bucket.put(id, Long.valueOf(nums[i]));
        }
        return false;
    }

    private long getId(long num, long w) {
        // num 可能为负数，减去 Integer.MIN_VALUE 这个偏移量得到非负数
        return (num - Integer.MIN_VALUE) / w;
    }
}
