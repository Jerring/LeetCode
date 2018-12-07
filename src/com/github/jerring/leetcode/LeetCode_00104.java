package com.github.jerring.leetcode;

public class LeetCode_00104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

//    public int maxDepth(TreeNode root) {
//        int res = 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        if (root != null) {
//            queue.offer(root);
//        }
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            while (size-- != 0) {
//                TreeNode node = queue.poll();
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//            ++res;
//        }
//        return res;
//    }
}
