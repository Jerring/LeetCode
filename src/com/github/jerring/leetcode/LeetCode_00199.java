package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00199 {

//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            while (size-- != 0) {
//                TreeNode node = queue.poll();
//                if (size == 0) {
//                    res.add(node.val);
//                }
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//        }
//        return res;
//    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int level){
        if(root == null) {
            return;
        }
        if(res.size() == level) {
            res.add(root.val);
        }
        // 先往右子树走
        helper(root.right, res, level + 1);
        helper(root.left, res, level + 1);
    }
}
