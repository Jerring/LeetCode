package com.github.jerring.leetcode;

public class LeetCode_00205 {

    public boolean isIsomorphic(String s, String t) {
        int[] map1 = new int[128];
        int[] map2 = new int[128];
        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map1[c1] != map2[c2]) {
                return false;
            }
            map1[c1] = i + 1;
            map2[c2] = i + 1;
        }
        return true;
    }
}
