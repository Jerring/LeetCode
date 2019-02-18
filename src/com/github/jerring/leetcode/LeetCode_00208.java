package com.github.jerring.leetcode;

public class LeetCode_00208 {

    class Trie {
        private class Node {
            Node[] next = new Node[26];
            boolean isEnd = false;
        }

        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.next[index] == null) {
                    node.next[index] = new Node();
                }
                node = node.next[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Node node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Node searchPrefix(String prefix) {
            Node node = root;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (node.next[index] == null) {
                    return null;
                }
                node = node.next[index];
            }
            return node;
        }
    }
}
