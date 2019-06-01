package com.github.jerring.leetcode;

public class LeetCode_00297 {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            encode(root, sb);
            return sb.toString();
        }

        private void encode(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#_");
                return;
            }
            sb.append(root.val).append('_');
            encode(root.left, sb);
            encode(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] s = data.split("_");
            int[] index = new int[]{0};
            return decode(s, index);
        }

        private TreeNode decode(String[] s, int[] index) {
            if ("#".equals(s[index[0]])) {
                ++index[0];
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(s[index[0]++]));
            root.left = decode(s, index);
            root.right = decode(s, index);
            return root;
        }
    }
}
