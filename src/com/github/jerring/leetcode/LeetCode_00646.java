package com.github.jerring.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_00646 {

    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int res = 1;
        int pre = pairs[0][1];
        for (int[] pair : pairs) {
            if (pair[0] > pre) {
                ++res;
                pre = pair[1];
            }
        }
        return res;
    }
}
