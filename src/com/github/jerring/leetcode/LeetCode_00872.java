package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        getLeafList(root1, list1);
        getLeafList(root2, list2);
        return list1.size() == list2.size() && list1.equals(list2);
    }

    private void getLeafList(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        getLeafList(root.left, list);
        getLeafList(root.right, list);
    }
}
