package com.github.jerring.leetcode;

public class LeetCode_00086 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode p = smallHead;
        ListNode q = largeHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                p.next = cur;
                p = p.next;
            } else {
                q.next = cur;
                q = q.next;
            }
            cur = cur.next;
        }
        p.next = largeHead.next;
        q.next = null;
        return smallHead.next;
    }
}
