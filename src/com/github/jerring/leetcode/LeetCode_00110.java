package com.github.jerring.leetcode;

public class LeetCode_00110 {

//    public boolean isBalanced(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
//            return false;
//        }
//        return isBalanced(root.left) && isBalanced(root.right);
//    }
//
//    private int depth(TreeNode root) {
//        return root == null ? 0 : 1 + Math.max(depth(root.left), depth(root.right));
//    }

    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = depth(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : 1 + Math.max(leftDepth, rightDepth);
    }
}
