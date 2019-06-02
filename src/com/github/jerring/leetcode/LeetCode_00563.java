package com.github.jerring.leetcode;

public class LeetCode_00563 {

    public int findTilt(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        res[0] += Math.abs(left - right);
        return root.val + left +right;
    }
}
