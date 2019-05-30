package com.github.jerring.leetcode;

public class LeetCode_00116 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur.left != null) {
            for (Node p = cur; p != null; p = p.next) {
                p.left.next = p.right;
                if (p.next != null) {
                    p.right.next = p.next.left;
                }
            }
            cur = cur.left;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
