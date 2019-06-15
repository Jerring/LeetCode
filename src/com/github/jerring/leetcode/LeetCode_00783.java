package com.github.jerring.leetcode;

public class LeetCode_00783 {

//    public int minDiffInBST(TreeNode root) {
//        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
//        TreeNode pre = null;
//        int res = Integer.MAX_VALUE;
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if (pre != null) {
//                res = Math.min(res, root.val - pre.val);
//            }
//            pre = root;
//            root = root.right;
//        }
//        return res;
//    }

    public int minDiffInBST(TreeNode root) {
        TreeNode[] pre = new TreeNode[1];
        int[] res = new int[]{Integer.MAX_VALUE};
        dfs(root, pre, res);
        return res[0];
    }

    private void dfs(TreeNode root, TreeNode[] pre, int[] res) {
        if (root == null) {
            return;
        }
        dfs(root.left, pre, res);
        if (pre[0] != null) {
            res[0] = Math.min(res[0], root.val - pre[0].val);
        }
        pre[0] = root;
        dfs(root.right, pre, res);
    }
}
