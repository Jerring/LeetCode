package com.github.jerring.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_00290 {

//    public boolean wordPattern(String pattern, String str) {
//        String[] split = str.split(" ");
//        if (pattern.length() != split.length) {
//            return false;
//        }
//        Map<Character, String> map = new HashMap<>();
//        for (int i = 0; i < pattern.length(); ++i) {
//            char c = pattern.charAt(i);
//            if (map.containsKey(c)) {
//                if (!map.get(c).equals(split[i])) {
//                    return false;
//                }
//            } else {
//                if (map.containsValue(split[i])) {
//                    return false;
//                }
//                map.put(c, split[i]);
//            }
//        }
//        return true;
//    }

    public boolean wordPattern(String pattern, String str) {
        String[] split = str.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); ++i) {
            char c = pattern.charAt(i);
            // 注意 Integer 间的比较用 equals，不要用 ==
            if (!map1.getOrDefault(c, -1).equals(map2.getOrDefault(split[i], -1))) {
                return false;
            }
            // 映射到当前索引
            map1.put(c, i);
            map2.put(split[i], i);
        }
        return true;
    }
}
