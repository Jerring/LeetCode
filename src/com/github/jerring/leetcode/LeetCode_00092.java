package com.github.jerring.leetcode;

public class LeetCode_00092 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 得到左边链表的尾结点
        ListNode leftTail = dummy;
        for (int i = 1; i < m; ++i) {
            leftTail = leftTail.next;
        }
        // 得到中间链表反转后的尾结点
        ListNode midTail = leftTail.next;
        ListNode cur = leftTail.next;
        ListNode pre = null;
        for (int i = 1; i <= n - m + 1; ++i) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 此时 pre 指向中间链表反转后的头结点
        leftTail.next = pre;
        // 此时 cur 指向右边链表的头结点
        midTail.next = cur;
        return dummy.next;
    }
}
