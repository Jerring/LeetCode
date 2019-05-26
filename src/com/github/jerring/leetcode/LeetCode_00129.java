package com.github.jerring.leetcode;

public class LeetCode_00129 {

    public int sumNumbers(TreeNode root) {
       return dfs(root, 0);
    }

    private int dfs(TreeNode root, int cur) {
        if (root == null) {
            return 0;
        }
        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            return cur;
        }
        return dfs(root.left, cur) + dfs(root.right, cur);
    }
}
