package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_00347 {

    // 时间复杂度 O(n)
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 构造一个从数据到出现次数的映射
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 构造一个桶的数组，桶内存放数据，桶的下标表示该数的出现次数
        // 因为可能存在相同出现次数的数据，每个桶采用 ArrayList 实现，可以存储多个数据
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(num);
        }
        List<Integer> topK = new ArrayList<>(k);
        // 从后往前遍历桶，即从出现次数高的到出现次数低的，注意跳过数据不存在的桶
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; --i) {
            if (buckets[i] != null) {
                topK.addAll(buckets[i]);
            }
        }
        return topK;
    }

//    时间复杂度 O(nlog(k))
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        // 构造一个从整数到出现次数的映射
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        // 构造一个小根堆，根据出现次数排序
//        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
//        for (Integer num : map.keySet()) {
//            heap.add(num);
//            if (heap.size() > k) {
//                heap.poll();
//            }
//        }
//        // 转为 List
//        return new ArrayList<>(heap);
//    }
}
