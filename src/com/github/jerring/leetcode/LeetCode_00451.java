package com.github.jerring.leetcode;

import java.util.*;

public class LeetCode_00451 {

    // 时间复杂度为 O(n)
    public String frequencySort(String s) {
        // 构建字符到出现次数的映射
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 构建桶，桶的下标表示出现次数
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(c);
        }
        // 从后往前（频率高到频率低）遍历，拼接得到结果
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; --i) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; ++j) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }

//    // 时间复杂度为 O(nlogn)
//    public String frequencySort(String s) {
//        // 构建字符到出现次数的映射
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        // 将 Map 转为 List
//        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
//        // 根据出现次数从大到小排序
//        Collections.sort(list, (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
//        // 拼接得到结果
//        StringBuilder sb = new StringBuilder();
//        for (Map.Entry<Character, Integer> entry : list) {
//            char c = entry.getKey();
//            int count = entry.getValue();
//            while (count-- != 0) {
//                sb.append(c);
//            }
//        }
//        return sb.toString();
//    }
}
