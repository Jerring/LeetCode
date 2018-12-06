package com.github.jerring.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_00103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        // 从左往右标志
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            while (size-- != 0) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    level.addLast(node.val);  // 从后面加
                } else {
                    level.addFirst(node.val); // 从前面加
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
            // 每一层结束前反转标志
            leftToRight = !leftToRight;
        }
        return res;
    }
}
