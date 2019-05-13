package com.github.jerring.leetcode;

public class LeetCode_00409 {

//    public int longestPalindrome(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        int res = 0;
//        int odd = 0;
//        for (int num : map.values()) {
//            if ((num & 1) == 1) {
//                res += num - 1;
//                odd = 1;
//            } else {
//                res += num;
//            }
//        }
//        res += odd;
//        return res;
//    }

    public int longestPalindrome(String s) {
        int[] map = new int[58];
        for (char c : s.toCharArray()) {
            ++map[c - 'A'];
        }
        int odd = 0;
        for (int num : map) {
            if ((num & 1) == 1) {
                ++odd;
            }
        }
        return odd == 0 ? s.length() : s.length() - odd + 1;
    }
}
