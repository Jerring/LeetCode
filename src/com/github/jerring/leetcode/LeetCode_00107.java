package com.github.jerring.leetcode;

import java.util.*;

public class LeetCode_00107 {

    // 迭代，从头添加
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            // 每一层的结点个数
            int size = queue.size();
            // 用来存储这一层结点的链表
            List<Integer> level = new LinkedList<>();
            while (size-- != 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 从头添加
            res.addFirst(level);
        }
        return res;
    }

    // 迭代，反转
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        if (root != null) {
//            queue.offer(root);
//        }
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            List<Integer> level = new ArrayList<>();
//            while (size-- != 0) {
//                TreeNode node = queue.poll();
//                level.add(node.val);
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//            res.add(level);
//        }
//        // 反转
//        Collections.reverse(res);
//        return res;
//    }

    // 递归版
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        traverse(root, 1, res);
//        // 反转
//        Collections.reverse(res);
//        return res;
//    }
//
//    private void traverse(TreeNode root, int level, List<List<Integer>> res) {
//        if (root == null) {
//            return;
//        }
//        if (res.size() < level) {
//            res.add(new ArrayList<>());
//        }
//        res.get(level - 1).add(root.val);
//        traverse(root.left, level + 1, res);
//        traverse(root.right, level + 1, res);
//    }
}
