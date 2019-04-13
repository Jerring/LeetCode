package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00438 {

//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> res = new ArrayList<>();
//        if (s.length() < p.length()) {
//            return res;
//        }
//        int[] sc = new int[26];
//        int[] pc = new int[26];
//        for (int i = 0; i < p.length(); ++i) {
//            ++sc[s.charAt(i) - 'a'];
//            ++pc[p.charAt(i) - 'a'];
//        }
//        if (Arrays.equals(sc, pc)) {
//            res.add(0);
//        }
//        for (int i = p.length(); i < s.length(); ++i) {
//            --sc[s.charAt(i - p.length()) - 'a'];
//            ++sc[s.charAt(i) - 'a'];
//            if (Arrays.equals(sc, pc)) {
//                res.add(i - p.length() + 1);
//            }
//        }
//        return res;
//    }

//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> res = new ArrayList<>();
//        if (s.length() < p.length()) {
//            return res;
//        }
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : p.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        int size = map.size();
//        int l = 0, r = 0;
//        while (r < s.length()) {
//            char c = s.charAt(r++);
//            if (map.containsKey(c)) {
//                map.put(c, map.get(c) - 1);
//                if (map.get(c) == 0) {
//                    --size;
//                }
//            }
//            while (size == 0) {
//                if (r - l == p.length()) {
//                    res.add(l);
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
//        return res;
//    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }
        int[] map = new int[26];
        for (char c : p.toCharArray()) {
            ++map[c - 'a'];
        }
        int size = p.length();
        int l = 0, r = 0;
        while (r < s.length()) {
            if (--map[s.charAt(r++) - 'a'] >= 0) {
                --size;
            }
            while (size == 0) {
                if (r - l == p.length()) {
                    res.add(l);
                }
                if (++map[s.charAt(l++) - 'a'] > 0) {
                    ++size;
                }
            }
        }
        return res;
    }
}
