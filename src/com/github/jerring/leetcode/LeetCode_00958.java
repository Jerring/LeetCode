package com.github.jerring.leetcode;

public class LeetCode_00958 {

//    public boolean isCompleteTree(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (queue.peek() != null) {
//            TreeNode node = queue.poll();
//            queue.offer(node.left);
//            queue.offer(node.right);
//        }
//        while (!queue.isEmpty() && queue.peek() == null) {
//            queue.poll();
//        }
//        return queue.isEmpty();
//    }

    public boolean isCompleteTree(TreeNode root) {
        int size = treeSize(root);
        return dfs(root, 1, size);
    }

    private boolean dfs(TreeNode root, int i, int size) {
        if (root == null) {
            return true;
        }
        if (i > size) {
            return false;
        }
        return dfs(root.left, i << 1, size) && dfs(root.right, i << 1 | 1, size);
    }

    private int treeSize(TreeNode root) {
        return root == null ? 0 : 1 + treeSize(root.left) + treeSize(root.right);
    }
}

