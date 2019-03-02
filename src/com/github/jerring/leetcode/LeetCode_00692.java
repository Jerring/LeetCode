package com.github.jerring.leetcode;

import java.util.*;

public class LeetCode_00692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // 构建小顶堆
        PriorityQueue<String> queue = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int diff = map.get(o1) - map.get(o2);
                if (diff != 0) {
                    return diff;
                }
                return o2.compareTo(o1);
            }
        });
        for (String s : map.keySet()) {
            queue.offer(s);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> res = new ArrayList<>(k);
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        // 翻转
        Collections.reverse(res);
        return res;
    }
}
