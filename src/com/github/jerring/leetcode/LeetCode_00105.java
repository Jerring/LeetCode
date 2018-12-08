package com.github.jerring.leetcode;

public class LeetCode_00105 {

    // 时间复杂度 O(n^2)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if (preBegin > preEnd || inBegin > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preBegin]);
        int i;
        for (i = inBegin; i <= inEnd; ++i) {
            if (root.val == inorder[i]) {
                break;
            }
        }
        // 从中序下标转化得到前序下标
        int leftEnd = preBegin + i - inBegin;
        root.left = buildTree(preorder, preBegin + 1, leftEnd, inorder, inBegin, i - 1);
        root.right = buildTree(preorder, leftEnd + 1, preEnd, inorder, i + 1, inEnd);
        return root;
    }

    // 对下标进行缓存，时间复杂度 O(n)
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < inorder.length; ++i) {
//            map.put(inorder[i], i);
//        }
//        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
//    }
//
//    private TreeNode buildTree(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd, Map<Integer, Integer> map) {
//        if (preBegin > preEnd || inBegin > inEnd) {
//            return null;
//        }
//        TreeNode root = new TreeNode(preorder[preBegin]);
//        int i = map.get(root.val);
//        int leftEnd = preBegin + i - inBegin;
//        root.left = buildTree(preorder, preBegin + 1, leftEnd, inorder, inBegin, i - 1, map);
//        root.right = buildTree(preorder, leftEnd + 1, preEnd, inorder, i + 1, inEnd, map);
//        return root;
//    }
}
