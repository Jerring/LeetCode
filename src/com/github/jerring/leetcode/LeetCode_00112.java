package com.github.jerring.leetcode;

public class LeetCode_00112 {

    // 递归
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

//    // 迭代
//    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null) {
//            return false;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            if (node.left == null && node.right == null && node.val == sum) {
//                return true;
//            }
//            if (node.right != null) {
//                node.right.val += node.val;
//                stack.push(node.right);
//            }
//            if (node.left != null) {
//                node.left.val += node.val;
//                stack.push(node.left);
//            }
//        }
//        return false;
//    }
}
