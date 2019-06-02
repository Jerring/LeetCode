package com.github.jerring.leetcode;

public class LeetCode_00538 {

    public TreeNode convertBST(TreeNode root) {
        int[] val = new int[1];
        dfs(root, val);
        return root;
    }

    private void dfs(TreeNode root, int[] val) {
        if (root == null) {
            return;
        }
        dfs(root.right, val);
        root.val += val[0];
        val[0] = root.val;
        dfs(root.left, val);
    }
}
