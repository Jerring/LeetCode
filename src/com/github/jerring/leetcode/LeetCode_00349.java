package com.github.jerring.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_00349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                set.add(nums1[i]);
                ++i;
                ++j;
            }
        }
        int[] res = new int[set.size()];
        i = 0;
        for (int num : set) {
            res[i++] = num;
        }
        return res;
    }

//    public int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> set = new HashSet<>();
//        Set<Integer> interset = new HashSet<>();
//        for (int num : nums1) {
//            set.add(num);
//        }
//        for (int num : nums2) {
//            if (set.contains(num)) {
//                interset.add(num);
//            }
//        }
//        int[] res = new int[interset.size()];
//        int i = 0;
//        for (int num : interset) {
//            res[i++] = num;
//        }
//        return res;
//    }
//
//    public int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> set = new HashSet<>();
//        Set<Integer> interset = new HashSet<>();
//        for (int num : nums1) {
//            set.add(num);
//        }
//        for (int num : nums2) {
//            interset.add(num);
//        }
//        interset.retainAll(set);
//        int[] res = new int[interset.size()];
//        int i = 0;
//        for (int num : interset) {
//            res[i++] = num;
//        }
//        return res;
//    }
}
