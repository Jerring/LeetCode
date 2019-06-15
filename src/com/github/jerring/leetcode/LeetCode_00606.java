package com.github.jerring.leetcode;

public class LeetCode_00606 {

//    public String tree2str(TreeNode t) {
//        if (t == null) {
//            return "";
//        }
//        if (t.right != null) {
//            return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
//        }
//        if (t.left != null) {
//            return t.val + "(" + tree2str(t.left) + ")";
//        }
//        return t.val + "";
//    }

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        dfs(t, sb);
        return sb.toString();
    }

    private void dfs(TreeNode t, StringBuilder sb) {
        if (t == null) {
            return;
        }
        sb.append(t.val);
        if (t.left != null) {
            sb.append('(');
            dfs(t.left, sb);
            sb.append(')');
        }
        if (t.right != null) {
            if (t.left == null) {
                sb.append("()");
            }
            sb.append('(');
            dfs(t.right, sb);
            sb.append(')');
        }
    }
}
