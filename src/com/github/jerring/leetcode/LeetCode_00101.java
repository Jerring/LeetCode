package com.github.jerring.leetcode;

public class LeetCode_00101 {

    // 一棵树的做法
    // 递归版本
    public boolean isSymmetric(TreeNode root) {
        // root 为 null 返回 true，否则判断它的左右子树是否是对称的
        return root == null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        // left 和 null 均为 null 时 返回 true，仅有一个返回 false
        if (left == null || right == null) {
            return left == right;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

//    // 迭代（左子树左中右，右子树右中左）
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        Deque<TreeNode> s1 = new ArrayDeque<>();
//        Deque<TreeNode> s2 = new ArrayDeque<>();
//        TreeNode left = root.left;
//        TreeNode right = root.right;
//        while (!s1.isEmpty() || left != null || right != null) {
//            while (left != null && right != null) {
//                s1.push(left);
//                s2.push(right);
//                left = left.left;
//                right = right.right;
//            }
//            if (left != null || right != null) {
//                return false;
//            }
//            left = s1.pop();
//            right = s2.pop();
//            if (left.val != right.val) {
//                return false;
//            }
//            left = left.right;
//            right = right.left;
//        }
//        return true;
//    }

    // 迭代版本（运用栈）
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        stack.push(root.left);
//        stack.push(root.right);
//        while (!stack.isEmpty()) {
//            TreeNode right = stack.pop();
//            TreeNode left = stack.pop();
//            if (left == null && right == null) {
//                continue;
//            }
//            if (left == null || right == null) {
//                return false;
//            }
//            if (left.val != right.val) {
//                return false;
//            }
//            stack.push(left.left);
//            stack.push(right.right);
//            stack.push(left.right);
//            stack.push(right.left);
//        }
//        return true;
//    }

    // 两棵树的做法
    // 递归版本
//    public boolean isSymmetric(TreeNode root) {
//        return isMirror(root, root);
//    }
//
//    private boolean isMirror(TreeNode p, TreeNode q) {
//        if (p == null && q == null) {
//            return true;
//        }
//        if (p == null || q == null) {
//            return false;
//        }
//        return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
//    }

    // 迭代版本（运用队列）
//    public boolean isSymmetric(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode p = queue.poll();
//            TreeNode q = queue.poll();
//            if (p == null && q == null) {
//                continue;
//            }
//            if (p == null || q == null) {
//                return false;
//            }
//            if (p.val != q.val) {
//                return false;
//            }
//            queue.offer(p.left);
//            queue.offer(q.right);
//            queue.offer(p.right);
//            queue.offer(q.left);
//        }
//        return true;
//    }
}
