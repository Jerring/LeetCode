package com.github.jerring.leetcode;

import java.util.Arrays;

public class LeetCode_01049 {

    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int n = sum >> 1;
        int[] f = new int[n + 1];
        for (int stone : stones) {
            for (int i = n; i >= stone; --i) {
                f[i] = Math.max(f[i], f[i - stone] + stone);
            }
        }
        return sum - 2 * f[n];
    }

//    public int lastStoneWeightII(int[] stones) {
//        int sum = Arrays.stream(stones).sum();
//        int n = sum >> 1;
//        boolean[] f = new boolean[n + 1];
//        f[0] = true;
//        for (int stone : stones) {
//            for (int i = n; i >= stone; --i) {
//                f[i] = f[i] | f[i - stone];
//            }
//        }
//        for (int i = n; i >= 0; --i) {
//            if (f[i]) {
//                return sum - 2 * i;
//            }
//        }
//        return sum;
//    }
}
