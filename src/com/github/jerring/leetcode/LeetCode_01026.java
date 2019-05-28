package com.github.jerring.leetcode;

public class LeetCode_01026 {

//    // 自底向上计算
//    public int maxAncestorDiff(TreeNode root) {
//        int[] res = new int[]{Integer.MIN_VALUE};
//        dfs(root, res);
//        return res[0];
//    }
//
//    private int[] dfs(TreeNode root, int[] res) {
//        if (root.left == null && root.right == null) {
//            return new int[]{root.val, root.val};
//        }
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        if (root.left != null) {
//            int[] left = dfs(root.left, res);
//            min = Math.min(min, left[0]);
//            max = Math.max(max, left[1]);
//        }
//        if (root.right != null) {
//            int[] right = dfs(root.right, res);
//            min = Math.min(min, right[0]);
//            max = Math.max(max, right[1]);
//        }
//        res[0] = Math.max(res[0], Math.max(Math.abs(root.val - min), Math.abs(root.val - max)));
//        min = Math.min(min, root.val);
//        max = Math.max(max, root.val);
//        return new int[]{min, max};
//    }

//    // 自顶向下计算
//    public int maxAncestorDiff(TreeNode root) {
//        return dfs(root, root.val, root.val);
//    }
//
//    private int dfs(TreeNode root, int min, int max) {
//        min = Math.min(min, root.val);
//        max = Math.max(max, root.val);
//        if (root.left == null && root.right == null) return max - min;
//        if (root.left == null) return dfs(root.right, min, max);
//        if (root.right == null) return dfs(root.left, min, max);
//        return Math.max(dfs(root.left, min, max), dfs(root.right, min, max));
//    }

    // 自顶向下计算
    public int maxAncestorDiff(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
        dfs(root, root.val, root.val, res);
        return res[0];
    }

    private void dfs(TreeNode root, int min, int max, int[] res) {
        if (root == null) {
            return;
        }
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        res[0] = Math.max(res[0], max - min);
        dfs(root.left, min, max, res);
        dfs(root.right, min, max, res);
    }
}
