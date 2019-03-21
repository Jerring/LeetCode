package com.github.jerring.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_00217 {

//    public boolean containsDuplicate(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 1; i < nums.length; ++i) {
//            if (nums[i] == nums[i - 1]) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
