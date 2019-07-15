package com.github.jerring.leetcode;

public class LeetCode_00092 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 得到左边链表的尾结点
        ListNode left = dummy;
        for (int i = 1; i < m; ++i) {
            left = left.next;
        }
        // 翻转
        ListNode cur = left.next;
        ListNode pre = null;
        for (int i = m; i <= n; ++i) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 此时 left.next 指向中间链表的尾结点，cur 指向右边链表的头结点
        left.next.next = cur;
        // 此时 pre 指向中间链表反转后的头结点
        left.next = pre;
        return dummy.next;
    }
}
