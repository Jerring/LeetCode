package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00077 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(k);
        dfs(n, k, 1, res, list);
        return res;
    }

    private void dfs(int n, int k, int s, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == k) {
            // 传入一个深拷贝
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = s; i <= n; ++i) {
            // 添加当前元素
            list.add(i);
            dfs(n, k, i + 1, res, list);
            // 恢复
            list.remove(list.size() - 1);
        }
    }

//    public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> res = new ArrayList<>();
//        int[] p = new int[k];
//        int i = 0;
//        while (i >= 0) {
//            ++p[i];
//            if (p[i] > n) {
//                --i;
//            } else if (i == k - 1) {
//                List<Integer> list = new ArrayList<>(k);
//                for (int t : p) {
//                    list.add(t);
//                }
//                res.add(list);
//            } else {
//                ++i;
//                p[i] = p[i - 1];
//            }
//        }
//        return res;
//    }
}
