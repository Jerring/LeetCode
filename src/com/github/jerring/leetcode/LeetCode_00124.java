package com.github.jerring.leetcode;

public class LeetCode_00124 {

    public int maxPathSum(TreeNode root) {
        int[] res = new int[] {root.val};
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left, res));
        int right = Math.max(0, dfs(root.right, res));
        res[0] = Math.max(res[0], root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
