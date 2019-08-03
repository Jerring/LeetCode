package com.github.jerring.leetcode;

public class LeetCode_01080 {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }
        limit -= root.val;
        if (root.left == null && root.right == null) {
            return limit > 0 ? null : root;
        }
        root.left = sufficientSubset(root.left, limit);
        root.right = sufficientSubset(root.right, limit);
        // 结点的左孩子与右孩子均被删除，则此结点也要被删除
        return root.left == null && root.right == null ? null : root;
    }
}
