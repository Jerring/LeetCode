package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_00090 {

//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        // 先排序
//        Arrays.sort(nums);
//        List<List<Integer>> res = new ArrayList<>();
//        dfs(0, nums, res, new ArrayList<>());
//        return res;
//    }
//
//    private void dfs(int s, int[] nums, List<List<Integer>> res, ArrayList<Integer> list) {
//        res.add(new ArrayList<>(list));
//        for (int i = s; i < nums.length; ++i) {
//            // 去重
//            if (i > s && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            list.add(nums[i]);
//            dfs(i + 1, nums, res, list);
//            list.remove(list.size() - 1);
//        }
//    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // 添加一个空集
        res.add(new ArrayList<>());
        int size = 0;
        // 枚举每一个元素
        for (int i = 0; i < nums.length; ++i) {
            // 跳过重复的部分，从上一次新添加的位置开始添加当前元素
            int s = (i > 0 && nums[i] == nums[i - 1]) ? size : 0;
            size = res.size();
            for (int j = s; j < size; ++j) {
                // 拷贝一份
                List<Integer> list = new ArrayList<>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
}
