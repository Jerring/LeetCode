package com.github.jerring.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_00106 {

    // 时间复杂度 O(n^2)
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
//    }
//
//    private TreeNode buildTree(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
//        if (inBegin > inEnd || postBegin > postEnd) {
//            return null;
//        }
//        TreeNode root = new TreeNode(postorder[postEnd]);
//        int i;
//        for (i = inBegin; i <= inEnd; ++i) {
//            if (root.val == inorder[i]) {
//                break;
//            }
//        }
//        int leftEnd = postBegin + i - inBegin - 1;
//        root.left = buildTree(inorder, inBegin, i - 1, postorder, postBegin, leftEnd);
//        root.right = buildTree(inorder, i + 1, inEnd, postorder, leftEnd + 1, postEnd - 1);
//        return root;
//    }

    // 对下标进行缓存，时间复杂度 O(n)
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode buildTree(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd, Map<Integer, Integer> map) {
        if (inBegin > inEnd || postBegin > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int i = map.get(root.val);
        int leftEnd = postBegin + i - inBegin - 1;
        root.left = buildTree(inorder, inBegin, i - 1, postorder, postBegin, leftEnd, map);
        root.right = buildTree(inorder, i + 1, inEnd, postorder, leftEnd + 1, postEnd - 1, map);
        return root;
    }
}
