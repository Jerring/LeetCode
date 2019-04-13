package com.github.jerring.leetcode;

public class LeetCode_00076 {

//    public String minWindow(String s, String t) {
//        if (s.length() < t.length()) {
//            return "";
//        }
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : t.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        int size = t.length();
//        int l = 0, r = 0;
//        int resL = 0, resR = Integer.MAX_VALUE;
//        while (r < s.length()) {
//            char c = s.charAt(r++);
//            if (map.containsKey(c)) {
//                map.put(c, map.get(c) - 1);
//                if (map.get(c) >= 0) {
//                    --size;
//                }
//            }
//            while (size == 0) {
//                if (r - l < resR - resL) {
//                    resL = l;
//                    resR = r;
//                }
//                c = s.charAt(l++);
//                if (map.containsKey(c)) {
//                    map.put(c, map.get(c) + 1);
//                    if (map.get(c) > 0) {
//                        ++size;
//                    }
//                }
//            }
//        }
//        return resR == Integer.MAX_VALUE ? "" : s.substring(resL, resR);
//    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            ++map[c];
        }
        int size = t.length();
        int l = 0, r = 0;
        int resL = 0, resR = Integer.MAX_VALUE;
        while (r < s.length()) {
            if (--map[s.charAt(r++)] >= 0) {
                --size;
            }
            while (size == 0) {
                if (r - l < resR - resL) {
                    resL = l;
                    resR = r;
                }
                if (++map[s.charAt(l++)] > 0) {
                    ++size;
                }
            }
        }
        return resR == Integer.MAX_VALUE ? "" : s.substring(resL, resR);
    }
}
