package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, res, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(list));
            }
        } else {
            dfs(root.left, sum, res, list);
            dfs(root.right, sum, res, list);
        }
        list.remove(list.size() - 1);
    }
}
