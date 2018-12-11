package com.github.jerring.leetcode;

public class LeetCode_00111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        // 保障一个根结点加上一个叶子结点的最小深度是 2，只有根结点的左右孩子均为空最小深度才为 1
        return leftDepth == 0 || rightDepth == 0 ? 1 + leftDepth + rightDepth : 1 + Math.min(leftDepth, rightDepth);
    }

    // 迭代，DFS
//    public int minDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        ArrayDeque<Pair> stack = new ArrayDeque<>();
//        stack.push(new Pair(root, 1));
//        int res = Integer.MAX_VALUE;
//        while (!stack.isEmpty()) {
//            Pair p = stack.pop();
//            TreeNode node = p.node;
//            int depth = p.depth;
//            if (node.left == null && node.right == null) {
//                res = Math.min(res, depth);
//            }
//            if (node.left != null && depth + 1 < res) {     // 剪枝
//                stack.push(new Pair(node.left, depth + 1));
//            }
//            if (node.right != null && depth + 1 < res) {    // 剪枝
//                stack.push(new Pair(node.right, depth + 1));
//            }
//        }
//        return res;
//    }
//
//    static class Pair {
//        TreeNode node;
//        int depth;
//
//        public Pair(TreeNode node, int depth) {
//            this.node = node;
//            this.depth = depth;
//        }
//    }
}
