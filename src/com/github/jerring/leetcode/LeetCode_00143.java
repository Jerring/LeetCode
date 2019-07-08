package com.github.jerring.leetcode;

public class LeetCode_00143 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode s = slow.next;
        slow.next = null;           // 断链
        ListNode h = reverse(s);    // 翻转
        while (h != null) {         // 合并
            ListNode next = head.next;
            head.next = h;
            head = h;
            h = next;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
