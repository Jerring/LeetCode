package com.github.jerring.leetcode;

public class LeetCode_00635 {

//    // 运用 HashSet
//    public boolean findTarget(TreeNode root, int k) {
//        Set<Integer> set = new HashSet<>();
//        return preOrder(root, k, set);
//    }
//
//    private boolean preOrder(TreeNode root, int k, Set<Integer> set) {
//        if (root == null) {
//            return false;
//        }
//        if (set.contains(k - root.val)) {
//            return true;
//        }
//        set.add(root.val);
//        return preOrder(root.left, k, set) || preOrder(root.right, k, set);
//    }

//    // 中序遍历得到有序数组后运用双指针
//    public boolean findTarget(TreeNode root, int k) {
//        List<Integer> list = new ArrayList<>();
//        inOrder(root, list);
//        int i = 0, j = list.size() - 1;
//        while (i < j) {
//            int s = list.get(i) + list.get(j);
//            if (s < k) {
//                ++i;
//            } else if (s > k) {
//                --j;
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private void inOrder(TreeNode root, List<Integer> list) {
//        if (root == null) {
//            return;
//        }
//        inOrder(root.left, list);
//        list.add(root.val);
//        inOrder(root.right, list);
//    }

    // 对每一个结点进行二分查找
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }

    private boolean dfs(TreeNode cur, TreeNode root, int k) {
        if (cur == null) {
            return false;
        }
        return search(cur, root, k - cur.val) || dfs(cur.left, root, k) || dfs(cur.right, root, k);
    }

    private boolean search(TreeNode cur, TreeNode root, int val) {
        if (root == null) {
            return false;
        }
        if (val < root.val) return search(cur, root.left, val);
        if (val > root.val) return search(cur, root.right, val);
        return cur != root;
    }
}