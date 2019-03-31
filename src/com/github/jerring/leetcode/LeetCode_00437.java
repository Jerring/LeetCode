package com.github.jerring.leetcode;

public class LeetCode_00437 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        return (sum == 0 ? 1 : 0) + pathSumFrom(root.left, sum) + pathSumFrom(root.right, sum);
    }
}
