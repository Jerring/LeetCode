package com.github.jerring.leetcode;

public class LeetCode_00222 {

//    public int countNodes(TreeNode root) {
//        return root == null ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
//    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = 0, rightDepth = 0;
        for (TreeNode node = root; node != null; node = node.left) {
            ++leftDepth;
        }
        for (TreeNode node = root; node != null; node = node.right) {
            ++rightDepth;
        }
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
