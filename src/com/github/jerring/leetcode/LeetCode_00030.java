package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_00030 {

//    public List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> res = new ArrayList<>();
//        if (words.length == 0 || s.length() < words.length * words[0].length()) {
//            return res;
//        }
//        Map<String, Integer> src = new HashMap<>();
//        for (String word : words) {
//            src.put(word, src.getOrDefault(word, 0) + 1);
//        }
//        int len = words[0].length();
//        int window = words.length * len;
//        // 分别从 [0, len) 开始寻找
//        for (int i = 0; i < len; ++i) {
//            // 复制一份，避免上次循环对这次的干扰
//            Map<String, Integer> map = new HashMap<>(src);
//            // 初始化 size 为当前单词数量
//            int size = words.length;
//            // 窗口 [l, r) 从本次起始位置 i 开始
//            int l = i, r = i;
//            while (r + len <= s.length()) {
//                String sub = s.substring(r, r + len);
//                r += len;
//                if (map.containsKey(sub)) {
//                    // 对应计数减一
//                    map.put(sub, map.get(sub) - 1);
//                    // 在有效范围内更新 size
//                    if (map.get(sub) >= 0) {
//                        --size;
//                    }
//                }
//                while (size == 0) {
//                    if (r - l == window) {
//                        res.add(l);
//                    }
//                    sub = s.substring(l, l + len);
//                    l += len;
//                    if (map.containsKey(sub)) {
//                        // 对应计数减一
//                        map.put(sub, map.get(sub) + 1);
//                        // 在有效范围内更新 size
//                        if (map.get(sub) > 0) {
//                            ++size;
//                        }
//                    }
//                }
//            }
//        }
//        return res;
//    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0 || s.length() < words.length * words[0].length()) {
            return res;
        }
        Map<String, Integer> src = new HashMap<>();
        for (String word : words) {
            src.put(word, src.getOrDefault(word, 0) + 1);
        }
        int len = words[0].length();
        int window = words.length * len;
        for (int i = 0; i < len; ++i) {
            // 构建一个空的 HashMap
            Map<String, Integer> map = new HashMap<>();
            int size = words.length;
            int l = i, r = i;
            while (r + len <= s.length()) {
                String sub = s.substring(r, r + len);
                r += len;
                if (src.containsKey(sub)) {
                    map.put(sub, map.getOrDefault(sub, 0) + 1);
                    // 在有效范围内更新 size
                    if (map.get(sub) <= src.get(sub)) {
                        --size;
                    }
                }
                while (size == 0) {
                    if (r - l == window) {
                        res.add(l);
                    }
                    sub = s.substring(l, l + len);
                    l += len;
                    if (src.containsKey(sub)) {
                        map.put(sub, map.get(sub) - 1);
                        // 在有效范围内更新 size
                        if (map.get(sub) < src.get(sub)) {
                            ++size;
                        }
                    }
                }
            }
        }
        return res;
    }
}
