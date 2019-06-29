package com.github.jerring.leetcode;

public class LeetCode_01094 {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] cnt = new int[1001];
        for (int[] trip : trips) {
            cnt[trip[1]] += trip[0];
            cnt[trip[2]] -= trip[0];
        }
        if (cnt[0] > capacity) return false;
        for (int i = 1; i < 1001; ++i) {
            cnt[i] += cnt[i - 1];
            if (cnt[i] > capacity) {
                return false;
            }
        }
        return true;
    }

//    public boolean carPooling(int[][] trips, int capacity) {
//        Map<Integer, Integer> map = new TreeMap<>();
//        for (int[] trip : trips) {
//            map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
//            map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
//        }
//        for (int v : map.values()) {
//            capacity -= v;
//            if (capacity < 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}

