package com.github.jerring.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode_00513 {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    res = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

//    public int findBottomLeftValue(TreeNode root) {
//        int[] res = dfs(root, 0);
//        return res[0];
//    }
//
//    private int[] dfs(TreeNode root, int level) {
//        if (root.left == null && root.right == null) return new int[]{root.val, level};
//        if (root.left == null) return dfs(root.right, level + 1);
//        if (root.right == null) return dfs(root.left, level + 1);
//        int[] left = dfs(root.left, level + 1);
//        int[] right = dfs(root.right, level + 1);
//        return left[1] >= right[1] ? left : right;
//    }
}
