package com.github.jerring.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_00354 {

//    public int maxEnvelopes(int[][] envelopes) {
//        if (envelopes == null || envelopes.length == 0) {
//            return 0;
//        }
//        Arrays.sort(envelopes, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] != o2[0]) {
//                    return Integer.compare(o1[0], o2[0]);
//                }
//                return Integer.compare(o2[1], o1[1]);
//            }
//        });
//        int n = envelopes.length;
//        int[] dp = new int[n];
//        for (int i = 0; i < n; ++i) {
//            dp[i] = 1;
//            for (int j = 0; j < i; ++j) {
//                if (envelopes[i][1] > envelopes[j][1]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//        }
//        int res = dp[0];
//        for (int d : dp) {
//            res = Math.max(res, d);
//        }
//        return res;
//    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o2[1], o1[1]);
            }
        });
        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int[] envelope: envelopes) {
            int i = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = envelope[1];
            if (i == len) {
                ++len;
            }
        }
        return len;
    }
}
