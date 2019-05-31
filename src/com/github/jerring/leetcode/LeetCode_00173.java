package com.github.jerring.leetcode;

import java.util.Stack;

public class LeetCode_00173 {

    class BSTIterator {
        private Stack<TreeNode> stack;
        private TreeNode root;

        public BSTIterator(TreeNode root) {
            this.stack = new Stack<>();
            this.root = root;
        }

        /** @return the next smallest number */
        public int next() {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            int res = root.val;
            root = root.right;
            return res;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty() || root != null;
        }
    }
}
