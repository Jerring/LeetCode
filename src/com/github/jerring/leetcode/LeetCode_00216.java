package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(k, n, 1, res, new ArrayList<>(k));
        return res;
    }

    private void dfs(int k, int n, int s, List<List<Integer>> res, ArrayList<Integer> list) {
        if (list.size() == k) {
            if (n == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = s; i <= 9; ++i) {
            list.add(i);
            dfs(k, n - i, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }
}
