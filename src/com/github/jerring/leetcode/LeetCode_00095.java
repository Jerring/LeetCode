package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00095 {

//    public List<TreeNode> generateTrees(int n) {
//        if (n < 1) {
//            return new ArrayList<>();
//        }
//        return dfs(1, n);
//    }
//
//    private List<TreeNode> dfs(int l, int r) {
//        List<TreeNode> res = new ArrayList<>();
//        if (l > r) {
//            res.add(null);
//            return res;
//        }
//        for (int i = l; i <= r; ++i) {
//            List<TreeNode> leftList = dfs(l, i - 1);
//            List<TreeNode> rightList = dfs(i + 1, r);
//            for (TreeNode left : leftList) {
//                for (TreeNode right : rightList) {
//                    TreeNode root = new TreeNode(i);
//                    root.left = left;
//                    root.right = right;
//                    res.add(root);
//                }
//            }
//        }
//        return res;
//    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<TreeNode>[] dp = new List[n + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(null);
        for (int i = 1; i <= n; i++) {
            dp[i] = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                for (TreeNode left : dp[j - 1]) {
                    for (TreeNode right : dp[i - j]) {
                        TreeNode node = new TreeNode(j);
                        node.left = left;              // 复用
                        node.right = copy(right, j);   // 加上偏移量复制一份
                        dp[i].add(node);
                    }
                }
            }
        }
        return dp[n];
    }

    private TreeNode copy(TreeNode root, int offset) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val + offset);
        node.left = copy(root.left, offset);
        node.right = copy(root.right, offset);
        return node;
    }
}
