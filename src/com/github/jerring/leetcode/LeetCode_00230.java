package com.github.jerring.leetcode;

public class LeetCode_00230 {

//    public int kthSmallest(TreeNode root, int k) {
//        int[] res = new int[] {0, 0};
//        inOrder(root, k, res);
//        return res[1];
//    }
//
//    private void inOrder(TreeNode root, int k, int[] res) {
//        if (root == null) {
//            return;
//        }
//        inOrder(root.left, k, res);
//        if (++res[0] == k) {
//            res[1] = root.val;
//            return;
//        }
//        inOrder(root.right, k, res);
//    }

//    public int kthSmallest(TreeNode root, int k) {
//        Stack<TreeNode> stack = new Stack<>();
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if (--k == 0) {
//                return root.val;
//            }
//            root = root.right;
//        }
//        return 0;
//    }

    public int kthSmallest(TreeNode root, int k) {
        int leftSize = treeSize(root.left);
        if (leftSize > k - 1) return kthSmallest(root.left, k);
        if (leftSize < k - 1) return kthSmallest(root.right, k - leftSize - 1);
        return root.val;
    }

    private int treeSize(TreeNode root) {
        return root == null ? 0 : 1 + treeSize(root.left) + treeSize(root.right);
    }
}
