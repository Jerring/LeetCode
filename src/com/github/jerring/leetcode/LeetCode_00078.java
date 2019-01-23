package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00078 {

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int m = 1 << n;
        List<List<Integer>> res = new ArrayList<>(m);
        for (int i = 0; i < m; ++i) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (((i >> j) & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }

//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        dfs(0, nums, res, new ArrayList<>());
//        return res;
//    }
//
//    private void dfs(int s, int[] nums, List<List<Integer>> res, List<Integer> list) {
//        res.add(new ArrayList<>(list));
//        for (int i = s; i < nums.length; ++i) {
//            list.add(nums[i]);
//            dfs(i + 1, nums, res, list);
//            list.remove(list.size() - 1);
//        }
//    }
}
