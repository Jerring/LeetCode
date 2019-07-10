package com.github.jerring.leetcode;

public class LeetCode_00013 {
    static int[] map = new int[128];

    static {
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
    }

    public int romanToInt(String s) {
        char[] cs = s.toCharArray();
        int res = 0;
        for (int i = 0; i < cs.length; ++i) {
            if (i + 1 < cs.length && map[cs[i]] < map[cs[i + 1]]) {
                res -= map[cs[i]];
            } else {
                res += map[cs[i]];
            }
        }
        return res;
    }
}
