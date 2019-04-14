package com.github.jerring.leetcode;

import java.util.*;

public class LeetCode_00350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            int val = map.getOrDefault(num, 0);
            if (val > 0) {
                list.add(num);
                map.put(num, val - 1);
            }
        }
        int i = 0;
        int[] res = new int[list.size()];
        for (int num : list) {
            res[i++] = num;
        }
        return res;
    }

//    public int[] intersect(int[] nums1, int[] nums2) {
//        List<Integer> list = new ArrayList<>();
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int n1 = nums1.length;
//        int n2 = nums2.length;
//        int i = 0;
//        int j = 0;
//        while (i < n1 && j < n2) {
//            if (nums1[i] < nums2[j]) {
//                ++i;
//            } else if (nums1[i] > nums2[j]) {
//                ++j;
//            } else {
//                list.add(nums1[i]);
//                ++i;
//                ++j;
//            }
//        }
//        i = 0;
//        int[] res = new int[list.size()];
//        for (int num : list) {
//            res[i++] = num;
//        }
//        return res;
//    }
}
