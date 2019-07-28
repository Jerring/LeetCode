package com.github.jerring.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_01048 {

//    public int longestStrChain(String[] words) {
//        Arrays.sort(words, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Integer.compare(o1.length(), o2.length());
//            }
//        });
//        int n = words.length;
//        int[] f = new int[n];
//        Arrays.fill(f, 1);
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < i; ++j) {
//                if (check(words[j], words[i])) {
//                    f[i] = Math.max(f[i], f[j] + 1);
//                }
//            }
//        }
//        int res = 0;
//        for (int x : f) {
//            res = Math.max(res, x);
//        }
//        return res;
//    }
//
//    private boolean check(String s, String t) {
//        if (s.length() + 1 != t.length()) {
//            return false;
//        }
//        int[] map = new int[26];
//        for (char c : t.toCharArray()) {
//            ++map[c - 'a'];
//        }
//        for (char c : s.toCharArray()) {
//            if (--map[c - 'a'] < 0) {
//                return false;
//            }
//        }
//        return true;
//    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int x = 1;
            for (int i = 0; i < word.length(); ++i) {
                String pre = word.substring(0, i) + word.substring(i + 1);
                x = Math.max(x, map.getOrDefault(pre, 0) + 1);
            }
            map.put(word, x);
            res = Math.max(res, x);
        }
        return res;
    }
}
