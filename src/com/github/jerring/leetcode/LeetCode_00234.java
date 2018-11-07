package com.github.jerring.leetcode;

public class LeetCode_00234 {

    // 反转前半部分链表
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 反转前半部分链表
        ListNode cur = head;
        ListNode pre = null;
        while (cur != slow) {
            ListNode nxet = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxet;
        }
        // 如果长度为奇数，跳过中心结点
        if (fast != null) {
            slow = slow.next;
        }
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    // 反转后半部分链表n
//    public boolean isPalindrome(ListNode head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//        ListNode fast = head;
//        ListNode slow = head;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        // 如果长度为奇数，跳过中心结点
//        if (fast != null) {
//            slow = slow.next;
//        }
//        // 反转后半部分链表
//        ListNode newHead = reverseList(slow);
//        while (newHead != null) {
//            if (head.val != newHead.val) {
//                return false;
//            }
//            head = head.next;
//            newHead = newHead.next;
//        }
//        return true;
//    }

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
}
