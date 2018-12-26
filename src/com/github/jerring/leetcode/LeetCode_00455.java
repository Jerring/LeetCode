package com.github.jerring.leetcode;

import java.util.Arrays;

public class LeetCode_00455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                ++i;
            }
            ++j;
        }
        return i;
    }
}
