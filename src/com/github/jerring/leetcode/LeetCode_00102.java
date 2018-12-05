package com.github.jerring.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_00102 {

    // 迭代版
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            // 每一行的结点个数
            int size = queue.size();
            // 用来存储一行元素的链表
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
            res.add(level);
        }
        return res;
    }

    // 递归版
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        traverse(root, 1, res);
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
