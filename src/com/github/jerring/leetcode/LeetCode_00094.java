package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00094 {

//    // 递归
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        inorderHelper(root, res);
//        return res;
//    }
//
//    private void inorderHelper(TreeNode root, List<Integer> list) {
//        if (root == null) {
//            return;
//        }
//        inorderHelper(root.left, list);
//        list.add(root.val);
//        inorderHelper(root.right, list);
//    }

//    // 迭代
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            res.add(root.val);
//            root = root.right;
//        }
//        return res;
//    }

    // Morris 遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        while (root != null) {
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            } else {
                TreeNode pre = getPredecessor(root);
                if (pre.right == null) {
                    pre.right = root;
                    root = root.left;
                } else {
                    res.add(root.val);
                    pre.right = null;
                    root = root.right;
                }
            }
        }
        return res;
    }

    private TreeNode getPredecessor(TreeNode root) {
        TreeNode p = root.left;
        while (p.right != null && p.right != root) {
            p = p.right;
        }
        return p;
    }
}
