package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00078 {

//    public List<List<Integer>> subsets(int[] nums) {
//        int n = nums.length;
//        int m = 1 << n;
//        List<List<Integer>> res = new ArrayList<>(m);
//        for (int i = 0; i < m; ++i) {
//            List<Integer> list = new ArrayList<>();
//            for (int j = 0; j < n; ++j) {
//                if (((i >> j) & 1) == 1) {
//                    list.add(nums[j]);
//                }
//            }
//            res.add(list);
//        }
//        return res;
//    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(1 << nums.length);
        // 首先添加一个空集
        res.add(new ArrayList<>());
        for (int num : nums) {
            // 枚举原来的每一个子集，把当前元素加入到所有子集中
            int size = res.size();
            for (int i = 0; i < size; ++i) {
                // 拷贝一份
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(num);
                res.add(list);
            }
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
