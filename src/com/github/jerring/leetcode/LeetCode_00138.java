package com.github.jerring.leetcode;

public class LeetCode_00138 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 复制每个结点并插入到它的后面
        Node node = head;
        while (node != null) {
            Node copy = new Node(node.val, node.next, node.random);
            node.next = copy;
            node = copy.next;
        }
        // 更改新建结点的 random 指针
        node = head;
        while (node != null) {
            node.next.random = node.random != null ? node.random.next : null;
            node = node.next.next;
        }
        // 分离得到原链表和新链表
        Node copiedHead = head.next;
        node = copiedHead;
        while (head != null) {
            head.next = head.next.next;
            head = head.next;
            node.next = head != null ? head.next : null;
            node = node.next;
        }
        return copiedHead;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
