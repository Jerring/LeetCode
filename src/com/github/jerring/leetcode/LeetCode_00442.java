package com.github.jerring.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_00442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            num = Math.abs(num);
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            } else {
                list.add(num);
            }
        }
        return list;
    }

//    public List<Integer> findDuplicates(int[] nums) {
//        List<Integer> list = new LinkedList<>();
//        boolean[] vis = new boolean[nums.length];
//        for (int num : nums) {
//            if (vis[num - 1]) {
//                list.add(num);
//            }
//            vis[num - 1] = true;
//        }
//        return list;
//    }
}
