package com.github.jerring.leetcode;

public class LeetCode_00100 {

    // 递归版本
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // 迭代版本
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p == null && q == null) {
//            return true;
//        }
//        if (p == null || q == null) {
//            return false;
//        }
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        stack.push(p);
//        stack.push(q);
//        while (!stack.isEmpty()) {
//            p = stack.pop();
//            q = stack.pop();
//            if (p == null && q == null) {
//                continue;
//            }
//            if (p == null || q == null) {
//                return false;
//            }
//            if (p.val != q.val) {
//                return false;
//            }
//            stack.push(p.left);
//            stack.push(q.left);
//            stack.push(p.right);
//            stack.push(q.right);
//        }
//        return true;
//    }
}
