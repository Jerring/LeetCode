package com.github.jerring.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_00496 {

//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        Deque<Integer> stack = new ArrayDeque<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = nums2.length - 1; i >= 0; --i) {
//            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
//                stack.pop();
//            }
//            map.put(nums2[i], !stack.isEmpty() ? stack.peek() : -1);
//            stack.push(nums2[i]);
//        }
//        int[] res = new int[nums1.length];
//        for (int i = 0; i < nums1.length; ++i) {
//            res[i] = map.get(nums1[i]);
//        }
//        return res;
//    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
