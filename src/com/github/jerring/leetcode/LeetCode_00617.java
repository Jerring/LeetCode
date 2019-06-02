package com.github.jerring.leetcode;

public class LeetCode_00617 {

//    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//        if (t1 == null) return t2;
//        if (t2 == null) return t1;
//        t1.val += t2.val;
//        t1.left = mergeTrees(t1.left, t2.left);
//        t1.right = mergeTrees(t1.right, t2.right);
//        return t1;
//    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        int val = (t1 != null ? t1.val : 0) + (t2 != null ? t2.val : 0);
        TreeNode root = new TreeNode(val);
        root.left = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
        root.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);
        return root;
    }
}
