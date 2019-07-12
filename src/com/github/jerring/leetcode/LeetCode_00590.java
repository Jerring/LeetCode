package com.github.jerring.leetcode;

import java.util.*;

public class LeetCode_00590 {

//    public List<Integer> postorder(Node root) {
//        List<Integer> res = new ArrayList<>();
//        dfs(root, res);
//        return res;
//    }
//
//    private void dfs(Node root, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        for (Node child : root.children) {
//            dfs(child, res);
//        }
//        res.add(root.val);
//    }

    public List<Integer> postorder(Node root) {
//        List<Integer> res = new ArrayList<>();
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(0, node.val);
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
