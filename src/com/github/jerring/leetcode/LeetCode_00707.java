package com.github.jerring.leetcode;

public class LeetCode_00707 {

    class MyLinkedList {
        class Node {
            int val;
            Node pre, next;
            Node(int val) {
                this.val = val;
            }
        }

        private void link(Node node1, Node node2) {
            node1.next = node2;
            node2.pre = node1;
        }

        private Node head;
        private Node tail;
        private int size;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            head = new Node(0);
            tail = new Node(0);
            size = 0;
            link(head, tail);
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            Node node = getNode(index);
            return node != null ? node.val : -1;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node node = new Node(val);
            link(node, head.next);
            link(head, node);
            ++size;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            Node node = new Node(val);
            link(tail.pre, node);
            link(node, tail);
            ++size;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            // 测试用例表明 index 为负插在头部
            if (index < 0) {
                addAtHead(val);
                return;
            }
            if (index == size) {
                addAtTail(val);
            } else {
                Node node = getNode(index);
                if (node != null) {
                    Node p = new Node(val);
                    link(node.pre, p);
                    link(p, node);
                    ++size;
                }
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            Node node = getNode(index);
            if (node != null) {
                link(node.pre, node.next);
                --size;
            }
        }

        private Node getNode(int index) {
            if (index < 0 || index >= size) {
                return null;
            }
            if (index < size >> 1) {    // 处于前半部分，顺序查找
                Node res = head.next;
                for (int i = 0; i < index; ++i) {
                    res = res.next;
                }
                return res;
            } else {                    // 处于后半部分，倒序查找
                Node res = tail.pre;
                index = size - 1 - index;
                for (int i = 0; i < index; ++i) {
                    res = res.pre;
                }
                return res;
            }
        }
    }
}
