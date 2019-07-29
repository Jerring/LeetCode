package com.github.jerring.leetcode;

import java.util.*;

public class LeetCode_00049 {

//    public List<List<String>> groupAnagrams(String[] strs) {
//        if (strs.length == 0) {
//            return new ArrayList<>();
//        }
//        Map<String, List<String>> map = new HashMap<>();
//        for (String s : strs) {
//            char[] cs = s.toCharArray();
//            Arrays.sort(cs);
//            String key = String.valueOf(cs);
//            if (!map.containsKey(key)) {
//                map.put(key, new ArrayList<>());
//            }
//            map.get(key).add(s);
//        }
//        return new ArrayList<>(map.values());
//    }

//    public List<List<String>> groupAnagrams(String[] strs) {
//        if (strs.length == 0) {
//            return new ArrayList<>();
//        }
//        Map<String, List<String>> map = new HashMap<>();
//        for (String s : strs) {
//            String id = getID(s);
//            if (!map.containsKey(id)) {
//                map.put(id, new ArrayList<>());
//            }
//            map.get(id).add(s);
//        }
//        return new ArrayList<>(map.values());
//    }
//
//    private String getID(String s) {
//        int[] cnt = new int[26];
//        for (char c : s.toCharArray()) {
//            ++cnt[c - 'a'];
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 26; ++i) {
//            sb.append('#').append(cnt[i]);
//        }
//        return sb.toString();
//    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int id = getID(s);
            List<String> list = map.computeIfAbsent(id, k -> new ArrayList<>());
            list.add(s);
        }
        return new ArrayList<>(map.values());
    }

    private int getID(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        return Arrays.hashCode(cnt);
    }
}
