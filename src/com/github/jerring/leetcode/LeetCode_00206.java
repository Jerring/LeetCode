package com.github.jerring.leetcode;

public class LeetCode_00206 {

    // 迭代版本
    public ListNode reverseList(ListNode head) {
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

    // 递归版本
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode newHead = reverseList(head.next);
//        // 在反转过程中，head 指向下一个结点的指针没有变化，故可以用 head.next获取到反转链表的尾结点
//        head.next.next = head;
//        head.next = null;
//        return newHead;
//    }
}
