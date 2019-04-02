package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_00145 {

//    // 递归
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        postHelper(root, res);
//        return res;
//    }
//
//    private void postHelper(TreeNode root, List<Integer> list) {
//        if (root == null) {
//            return;
//        }
//        postHelper(root.left, list);
//        postHelper(root.right, list);
//        list.add(root.val);
//    }

//    // 迭代（运用两个栈）
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        Stack<Integer> data = new Stack<>();
//        stack.push(root);
//        while (!stack.empty()) {
//            TreeNode p = stack.pop();
//            data.push(p.val);
//            if (p.left != null) {
//                stack.push(p.left);
//            }
//            if (p.right != null) {
//                stack.push(p.right);
//            }
//        }
//        while (!data.isEmpty()) {
//            res.add(data.pop());
//        }
//        return res;
//    }

//    // 迭代（运用一个栈 + 最后 reverse）
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.empty()) {
//            TreeNode p = stack.pop();
//            res.add(p.val);
//            if (p.left != null) {
//                stack.push(p.left);
//            }
//            if (p.right != null) {
//                stack.push(p.right);
//            }
//        }
//        Collections.reverse(res);
//        return res;
//    }

    // 迭代（运用一个栈 + 从头添加）
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode p = stack.pop();
            res.add(0, p.val);
            if (p.left != null) {
                stack.push(p.left);
            }
            if (p.right != null) {
                stack.push(p.right);
            }
        }
        return res;
    }
}
