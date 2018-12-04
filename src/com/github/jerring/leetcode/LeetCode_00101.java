package com.github.jerring.leetcode;

public class LeetCode_00101 {

    // 递归版本
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

    // 迭代版本（运用队列）
//    public boolean isSymmetric(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode p = queue.poll();
//            TreeNode q = queue.poll();
//            if (p == null && q == null) {
//                continue;
//            }
//            if (p == null || q == null) {
//                return false;
//            }
//            if (p.val != q.val) {
//                return false;
//            }
//            queue.offer(p.left);
//            queue.offer(q.right);
//            queue.offer(p.right);
//            queue.offer(q.left);
//        }
//        return true;
//    }
}
