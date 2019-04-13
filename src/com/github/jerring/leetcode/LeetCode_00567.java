package com.github.jerring.leetcode;

public class LeetCode_00567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] map = new int[26];
        for (char c : s1.toCharArray()) {
            ++map[c - 'a'];
        }
        int size = s1.length();
        int l = 0, r = 0;
        while (r < s2.length()) {
            if (--map[s2.charAt(r++) - 'a'] >= 0) {
                --size;
            }
            while (size == 0) {
                if (r - l == s1.length()) {
                    return true;
                }
                if (++map[s2.charAt(l++) - 'a'] > 0) {
                    ++size;
                }
            }
        }
        return false;
    }

//    public boolean checkInclusion(String s1, String s2) {
//        if (s1.length() > s2.length()) {
//            return false;
//        }
//        int[] map = new int[26];
//        for (int i = 0; i < s1.length(); ++i) {
//            ++map[s1.charAt(i) - 'a'];
//            --map[s2.charAt(i) - 'a'];
//        }
//        if (allzeros(map)) {
//            return true;
//        }
//        for (int i = s1.length(); i < s2.length(); ++i) {
//            --map[s2.charAt(i) - 'a'];
//            ++map[s2.charAt(i - s1.length()) - 'a'];
//            if (allzeros(map)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean allzeros(int[] nums) {
//        for (int num : nums) {
//            if (num != 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}
