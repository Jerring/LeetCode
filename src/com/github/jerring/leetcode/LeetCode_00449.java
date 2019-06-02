package com.github.jerring.leetcode;

public class LeetCode_00449 {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            encode(root, sb);
            return sb.toString();
        }

        private void encode(TreeNode root, StringBuilder sb) {
            // 为 null 直接返回，不再添加额外字符表示 null
            if (root == null) {
                return;
            }
            sb.append(root.val).append('_');
            encode(root.left, sb);
            encode(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            // 解析 ""
            if (data.isEmpty()) {
                return null;
            }
            String[] s = data.split("_");
            int[] index = new int[]{0};
            return decode(s, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode decode(String[] s, int[] index, int min, int max) {
            if (index[0] == s.length) {
                return null;
            }
            // 不匹配则返回
            int val = Integer.parseInt(s[index[0]]);
            if (val < min || val > max) {
                return null;
            }
            ++index[0];
            TreeNode root = new TreeNode(val);
            root.left = decode(s, index, min, val);
            root.right = decode(s, index, val, max);
            return root;
        }
    }
}
