package com.github.jerring.leetcode;

public class LeetCode_00114 {

//    // 递归
//    public void flatten(TreeNode root) {
//        // 终止条件
//        if (root == null) {
//            return;
//        }
//        // 展开左子树
//        flatten(root.left);
//        // 展开右子树
//        flatten(root.right);
//        // 左子树为空直接返回
//        if (root.left == null) {
//            return;
//        }
//        // 将展开后的左子树插入到当前结点与右子树之间
//        TreeNode p = root.left;
//        while (p.right != null) {
//            p = p.right;
//        }
//        p.right = root.right;
//        root.right = root.left;
//        root.left = null;
//    }

    // 迭代
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode p = cur.left;
                while (p.right != null) {
                    p = p.right;
                }
                p.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
