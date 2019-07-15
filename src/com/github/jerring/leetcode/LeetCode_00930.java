package com.github.jerring.leetcode;

public class LeetCode_00930 {

//    public int numSubarraysWithSum(int[] A, int S) {
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0, 1);
//        int res = 0;
//        int s = 0;
//        for (int a : A) {
//            s += a;
//            res += map.getOrDefault(s - S, 0);
//            map.put(s, map.getOrDefault(s, 0) + 1);
//        }
//        return res;
//    }

    public int numSubarraysWithSum(int[] A, int S) {
        int[] map = new int[A.length + 1];
        map[0] = 1;
        int res = 0;
        int s = 0;
        for (int a : A) {
            s += a;
            if (s >= S) {
                res += map[s - S];
            }
            ++map[s];
        }
        return res;
    }
}
