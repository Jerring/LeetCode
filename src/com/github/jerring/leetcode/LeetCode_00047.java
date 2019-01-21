package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00047 {

//    public List<List<Integer>> permuteUnique(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> res = new ArrayList<>();
//        do {
//            List<Integer> list = new ArrayList<>(nums.length);
//            for (int num : nums) {
//                list.add(num);
//            }
//            res.add(list);
//        } while (nextPermutation(nums));
//        return res;
//    }
//
//    private boolean nextPermutation(int[] nums) {
//        // 1. 从后往前找到第一组位置，满足 nums[i] < nums[i + 1]
//        int i = nums.length - 2;
//        while (i >= 0 && nums[i] >= nums[i + 1]) {
//            --i;
//        }
//        if (i >= 0) {
//            // 2. 从后往前找到第一个位置，满足 nums[i] < nums[j]
//            int j = nums.length - 1;
//            while (nums[i] >= nums[j]) {
//                --j;
//            }
//            // 3. 交换 i、j 两处的值
//            swap(nums, i, j);
//            // 4. 反转从位置 i + 1 到末尾的序列
//            reverse(nums, i + 1, nums.length - 1);
//            return true;
//        }
//        return false;
//    }
//
//    private void reverse(int[] nums, int i, int j) {
//        while (i < j) {
//            swap(nums, i++, j--);
//        }
//    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int s) {
        if (s == nums.length) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }
        for (int i = s; i < nums.length; ++i) {
            if (isDuplicate(nums, s, i)) {
                continue;
            }
            swap(nums, i, s);
            dfs(nums, res, s + 1);
            swap(nums, i, s);
        }
    }

    private boolean isDuplicate(int[] nums, int s, int e) {
        for (int i = s; i < e; ++i) {
            if (nums[i] == nums[e]) {
                return true;
            }
        }
        return false;
    }
}
