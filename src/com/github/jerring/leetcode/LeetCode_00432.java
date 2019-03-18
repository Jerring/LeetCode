package com.github.jerring.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode_00432 {

    class AllOne {
        private class Node {
            int value;
            Set<String> keys;
            Node pre;
            Node next;

            Node(int value) {
                this.value = value;
                this.keys = new HashSet<>();
            }
        }

        private Map<String, Node> map;
        private Node head;
        private Node tail;

        public AllOne() {
            map = new HashMap<>();
            head = new Node(0);
            tail = new Node(0);
            link(head, tail);
        }

        public void inc(String key) {
            Node node = map.get(key);
            if (node == null) {
                if (head.next.value == 1) {
                    map.put(key, head.next);
                    head.next.keys.add(key);
                } else {
                    addNodeAfter(head, key, 1);
                }
            } else {
                int newValue = node.value + 1;
                if (newValue == node.next.value) {
                    map.put(key, node.next);
                    node.next.keys.add(key);
                } else {
                    addNodeAfter(node, key, newValue);
                }
                node.keys.remove(key);
                if (node.keys.isEmpty()) {
                    link(node.pre, node.next);
                }
            }
        }


        public void dec(String key) {
            Node node = map.get(key);
            if (node == null) {
                return;
            }
            int newValue = node.value - 1;
            if (newValue == node.pre.value) {
                if (newValue == 0) {
                    map.remove(key);
                } else {
                    map.put(key, node.pre);
                    node.pre.keys.add(key);
                }
            } else {
                addNodeAfter(node, key, newValue);
            }
            node.keys.remove(key);
            if (node.keys.isEmpty()) {
                link(node.pre, node.next);
            }
        }

        public String getMaxKey() {
            return head.next == tail ? "" : tail.pre.keys.iterator().next();
        }

        public String getMinKey() {
            return tail.pre == head ? "" : head.next.keys.iterator().next();
        }

        private void link(Node node1, Node node2) {
            node1.next = node2;
            node2.pre = node1;
        }

        private void addNodeAfter(Node node, String key, int value) {
            Node newNode = new Node(value);
            newNode.keys.add(key);
            map.put(key, newNode);
            link(newNode, node.next);
            link(node, newNode);
        }
    }
}
