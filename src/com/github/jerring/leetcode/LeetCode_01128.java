package com.github.jerring.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_01128 {

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] d : dominoes) {
            int x = d[0] < d[1] ? d[0] * 10 + d[1] : d[1] * 10 + d[0];
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int res = 0;
        for (int v : map.values()) {
            res += v * (v - 1) / 2;
        }
        return res;
    }
}

