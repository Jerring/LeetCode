package com.github.jerring.leetcode;

public class LeetCode_00226 {

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = invertTree(right);
            root.right = invertTree(left);
        }
        return root;
    }

//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            TreeNode tmp = node.left;
//            node.left = node.right;
//            node.right = tmp;
//            if (node.left != null) {
//                queue.offer(node.left);
//            }
//            if (node.right != null) {
//                queue.offer(node.right);
//            }
//        }
//        return root;
//    }
}
