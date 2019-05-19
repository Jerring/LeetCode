package com.github.jerring.leetcode;

import java.util.*;

public class LeetCode_00187 {

//    public List<String> findRepeatedDnaSequences(String s) {
//        Map<String, Integer> map = new HashMap<>();
//        for (int i = 10; i <= s.length(); ++i) {
//            String sub = s.substring(i - 10, i);
//            map.put(sub, map.getOrDefault(sub, 0) + 1);
//        }
//        List<String> res = new ArrayList<>();
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > 1) {
//                res.add(entry.getKey());
//            }
//        }
//        return res;
//    }

    public static List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return new ArrayList<>();
        }
        char[] cs = s.toCharArray();
        int n = cs.length;
        byte[] f = new byte[85];
        f['A'] = 0;
        f['C'] = 1;
        f['G'] = 2;
        f['T'] = 3;
        BitSet vis = new BitSet();
        BitSet add = new BitSet();
        List<String> res = new ArrayList<>(n >> 1);
        int v = 0;
        for (int i = 0; i < 9; ++i) {
            v = (v << 2) | f[cs[i]];
        }
        for (int i = 9; i < n; ++i) {
            v = (v << 2) & 0xfffff | f[cs[i]];
            if (vis.get(v)) {
                if (!add.get(v)) {
                    res.add(String.valueOf(cs, i - 9, 10));
                    add.set(v);
                }
            } else {
                vis.set(v);
            }
        }
        return res;
    }
}
