package com.github.jerring.leetcode;

public class LeetCode_00024 {

    // 迭代
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = cur.next.next;
        }
        return dummy.next;
    }

//    // 递归
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode p = head;
//        head = head.next;
//        p.next = head.next;
//        head.next = p;
//        p.next = swapPairs(p.next);
//        return head;
//    }
}
