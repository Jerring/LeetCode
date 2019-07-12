package com.github.jerring.leetcode;

public class LeetCode_00965 {

    public boolean isUnivalTree(TreeNode root) {
        return (root.left == null || root.val == root.left.val && isUnivalTree(root.left))
                && (root.right == null || root.val == root.right.val && isUnivalTree(root.right));
    }
}

