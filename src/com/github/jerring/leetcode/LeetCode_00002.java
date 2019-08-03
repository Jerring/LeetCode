package com.github.jerring.leetcode;

public class LeetCode_00002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            carry += (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            cur.next = new ListNode(carry % 10);
            cur = cur.next;
            carry /= 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}
