package com.github.jerring.leetcode;

public class LeetCode_00082 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = cur;              // 没有重复，移动 pre 为当前结点
            } else {
                pre.next = cur.next;    // 存在重复，跳过所有重复的结点
            }
            cur = cur.next;             // 移动到下一结点
        }
        return dummy.next;
    }
}
