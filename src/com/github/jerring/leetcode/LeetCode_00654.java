package com.github.jerring.leetcode;

public class LeetCode_00654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int index = l;
        for (int i = l + 1; i <= r; ++i) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = dfs(nums, l, index - 1);
        root.right = dfs(nums, index + 1, r);
        return root;
    }

//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return null;
//        }
//        Deque<TreeNode> deque = new ArrayDeque<>();
//        for (int num : nums) {
//            TreeNode node = new TreeNode(num);
//            while (!deque.isEmpty() && deque.peekLast().val < num) {
//                node.left = deque.pollLast();
//            }
//            if (!deque.isEmpty()) {
//                deque.peekLast().right = node;
//            }
//            deque.offerLast(node);
//        }
//        return deque.peekFirst();
//    }
}
