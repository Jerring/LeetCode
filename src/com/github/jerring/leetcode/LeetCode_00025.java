package com.github.jerring.leetcode;

public class LeetCode_00025 {

//    // 递归
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode cur = head;
//        int cnt = 0;
//        while (cnt < k && cur != null) {
//            ++cnt;
//            cur = cur.next;
//        }
//        // 不足 k 个直接返回
//        if (cnt < k) {
//            return head;
//        }
//        // 翻转 k 个结点
//        cur = head;
//        ListNode pre = null;
//        for (int i = 0; i < k; ++i) {
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        // 递归翻转剩余结点
//        head.next = reverseKGroup(cur, k);
//        return pre;
//    }

    // 迭代
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        // 新建一个哑结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        int cnt = 0;
        while (cur != null) {
            if (++cnt == k) {
                cnt = 0;
                // 翻转区间 [begin, next)
                ListNode begin = pre.next;
                ListNode next = cur.next;
                pre.next = reverse(begin, next);
                // begin 为翻转后的尾结点，链上后面的结点
                begin.next = next;
                pre = begin;
                cur = next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    /**
     * 翻转区间 [begin, end) 的链表
     * @param begin 起始结点（包含）
     * @param end 终止结点（不包含）
     * @return 翻转后的头结点
     */
    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode cur = begin;
        ListNode pre = null;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
