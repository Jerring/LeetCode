package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int level, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (list.size() == level) {
            list.add(root.val);
        } else {
            if (root.val > list.get(level)) {
                list.set(level, root.val);
            }
        }
        dfs(root.left, level + 1, list);
        dfs(root.right, level + 1, list);
    }

//    public List<Integer> largestValues(TreeNode root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        List<Integer> res = new ArrayList<>();
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            int max = Integer.MIN_VALUE;
//            while (size-- != 0) {
//                TreeNode node = queue.poll();
//                max = Math.max(max, node.val);
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//            res.add(max);
//        }
//        return res;
//    }
}
