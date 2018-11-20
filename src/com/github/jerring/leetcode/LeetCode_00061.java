package com.github.jerring.leetcode;

public class LeetCode_00061 {

    public ListNode rotateRight(ListNode head, int k) {
        // 如果链表为空或链表长度为 1 或 k == 0，直接返回
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // 计算链表长度
        ListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            ++len;
            cur = cur.next;
        }
        // 取模可以避免重复遍历
        k %= len;
        // 如果 k 是链表长度的整数倍，那么移动后的结果与原始链表相同
        if (k == 0) {
            return head;
        }
        // 将尾结点链接到头结点，再移动 cur 让它指向结果链表的尾结点
        cur.next = head;
        int loop = len - k;
        for (int i = 1; i <= loop; ++i) {
            cur = cur.next;
        }
        // cur.next 为新的头结点
        head = cur.next;
        // 置 cur.next 为 null
        cur.next = null;
        return head;
    }
}
