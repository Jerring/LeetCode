package com.github.jerring.leetcode;

public class LeetCode_00897 {

//    public TreeNode increasingBST(TreeNode root) {
//        TreeNode dummy = new TreeNode(0);
//        inOrder(root, new TreeNode[]{dummy});
//        return dummy.right;
//    }
//
//    private void inOrder(TreeNode root, TreeNode[] pre) {
//        if (root == null) {
//            return;
//        }
//        inOrder(root.left, pre);
//        root.left = null;
//        pre[0].right = root;
//        pre[0] = pre[0].right;
//        inOrder(root.right, pre);
//    }

//    public TreeNode increasingBST(TreeNode root) {
//        TreeNode dummy = new TreeNode(0);
//        TreeNode pre = dummy;
//        Stack<TreeNode> stack = new Stack<>();
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            root.left = null;
//            pre.right = root;
//            pre = root;
//            root = root.right;
//        }
//        return dummy.right;
//    }

    public TreeNode increasingBST(TreeNode root) {
        return inOrder(root, null);
    }

    private TreeNode inOrder(TreeNode root, TreeNode tail) {
        if (root == null) {
            return tail;
        }
        TreeNode head = inOrder(root.left, root);
        root.left = null;
        root.right = inOrder(root.right, tail);
        return head;
    }
}
