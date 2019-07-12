package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00429 {

//    public List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        Deque<Node> queue = new ArrayDeque<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            List<Integer> level = new ArrayList<>(size);
//            while (size-- != 0) {
//                Node node = queue.poll();
//                level.add(node.val);
//                for (Node child : node.children) {
//                    queue.offer(child);
//                }
//            }
//            res.add(level);
//        }
//        return res;
//    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(Node root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level++).add(root.val);
        for (Node child : root.children) {
            dfs(child, level, res);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
