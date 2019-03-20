package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00144 {

//    // 递归
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        preHelper(root, res);
//        return res;
//    }
//
//    private void preHelper(TreeNode root, List<Integer> list) {
//        if (root == null) {
//            return;
//        }
//        list.add(root.val);
//        preHelper(root.left, list);
//        preHelper(root.right, list);
//    }

//    // 迭代
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.empty()) {
//            TreeNode p = stack.pop();
//            res.add(p.val);
//            if (p.right != null) {
//                stack.push(p.right);
//            }
//            if (p.left != null) {
//                stack.push(p.left);
//            }
//        }
//        return res;
//    }

    // Morris 遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        while (root != null) {
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            } else {
                TreeNode pre = getPredecessor(root);
                if (pre.right == null) {
                    res.add(root.val);
                    pre.right = root;
                    root = root.left;
                } else {
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
