package com.github.jerring.leetcode;

public class LeetCode_00237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
