package com.github.jerring.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_00146 {

//    // 运用 LinkedHashMap
//    class LRUCache {
//        private Map<Integer, Integer> map;
//        private final int CAPACITY;
//
//        public LRUCache(int capacity) {
//            CAPACITY = capacity;
//            // accessOrder 为 true 表示排序模式为按照访问顺序（false 表示排序模式为按照插入顺序）
//            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
//                @Override
//                protected boolean removeEldestEntry(Map.Entry eldest) {
//                    return size() > CAPACITY;
//                }
//            };
//        }
//
//        public int get(int key) {
//            return map.getOrDefault(key, -1);
//        }
//
//        public void put(int key, int value) {
//            map.put(key, value);
//        }
//    }

    // 运用 HashMap + 实现双向链表
    class LRUCache {
        private class Node {
            int key;
            int value;
            Node pre;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Map<Integer, Node> map;
        private int capacity;
        private int size;
        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
            this.size = 0;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node == null) {
                node = new Node(key, value);
                map.put(key, node);
                add(node);
                ++size;
                if (size > capacity) {
                    Node rm = tail.pre;
                    map.remove(rm.key);
                    remove(rm);
                    --size;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        /**
         * 移动结点至队首
         * @param node 待移动结点
         */
        private void moveToHead(Node node) {
            remove(node);
            add(node);
        }

        /**
         * 添加结点至队首
         * @param node 待添加结点
         */
        private void add(Node node) {
            link(node, head.next);
            link(head, node);
        }

        /**
         * 删除结点
         * @param node 待删除结点
         */
        private void remove(Node node) {
            link(node.pre, node.next);
        }

        /**
         * 链接 node1 和 node2
         * @param node1 前一个结点
         * @param node2 后一个结点
         */
        private void link(Node node1, Node node2) {
            node1.next = node2;
            node2.pre = node1;
        }
    }
}
