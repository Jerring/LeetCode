package com.github.jerring.leetcode;

public class LeetCode_00530 {

//    public int getMinimumDifference(TreeNode root) {
//        int res = Integer.MAX_VALUE;
//        Stack<TreeNode> stack = new Stack<>();
//        Integer pre = null;
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if (pre != null) {
//                res = Math.min(res, root.val - pre);
//            }
//            pre = root.val;
//            root = root.right;
//        }
//        return res;
//    }

//    public int getMinimumDifference(TreeNode root) {
//        int[] pre = new int[]{-1};
//        int[] res = new int[]{Integer.MAX_VALUE};
//        inOrder(root, pre, res);
//        return res[0];
//    }
//
//    private void inOrder(TreeNode root, int[] pre, int[] res) {
//        if (root == null) {
//            return;
//        }
//        inOrder(root.left, pre, res);
//        if (pre[0] != -1) {
//            res[0] = Math.min(res[0], root.val - pre[0]);
//        }
//        pre[0] = root.val;
//        inOrder(root.right, pre, res);
//    }

    public int getMinimumDifference(TreeNode root) {
        int[] res = new int[]{Integer.MAX_VALUE};
        dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE, res);
        return res[0];
    }

    private void dfs(TreeNode root, int min, int max, int[] res) {
        if (root == null) {
            return;
        }
        if (min != Integer.MIN_VALUE) res[0] = Math.min(res[0], root.val - min);
        if (max != Integer.MAX_VALUE) res[0] = Math.min(res[0], max - root.val);
        dfs(root.left, min, root.val, res);
        dfs(root.right, root.val, max, res);
    }
}
