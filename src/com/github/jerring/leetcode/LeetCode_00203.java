package com.github.jerring.leetcode;

public class LeetCode_00203 {

    public ListNode removeElements(ListNode head, int val) {
        // 为了方便链表头结点被删除的操作，可以新建一个头结点
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode cur = head;
        ListNode pre = newhead;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return newhead.next;
    }

//    public ListNode removeElements(ListNode head, int val) {
//        while (head != null && head.val == val) {   // 找到第一个值不等于 val 的非空结点
//            head = head.next;
//        }
//        if (head == null) {                         // 不满足直接返回 null
//            return null;
//        }
//        ListNode cur = head.next;
//        ListNode pre = head;
//        while (cur != null) {
//            if (cur.val == val) {
//                pre.next = cur.next;
//            } else {
//                pre = cur;
//            }
//            cur = cur.next;
//        }
//        return head;
//    }
}
