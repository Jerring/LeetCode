package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00257 {

//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> res = new ArrayList<>();
//        if (root != null) {
//            dfs(root, String.valueOf(root.val), res);
//        }
//        return res;
//    }
//
//    private void dfs(TreeNode root, String path, List<String> res) {
//        if (root.left == null && root.right == null) {
//            res.add(path);
//            return;
//        }
//        if (root.left != null) {
//            dfs(root.left, path + "->" + root.left.val, res);
//        }
//        if (root.right != null) {
//            dfs(root.right, path + "->" + root.right.val, res);
//        }
//    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        String cur = String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            res.add(cur);
            return res;
        }
        List<String> list = binaryTreePaths(root.left);
        for (String s : list) {
            res.add(cur + "->" + s);
        }
        list = binaryTreePaths(root.right);
        for (String s : list) {
            res.add(cur + "->" + s);
        }
        return res;
    }
}
