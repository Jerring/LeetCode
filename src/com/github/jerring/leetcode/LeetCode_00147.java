package com.github.jerring.leetcode;

public class LeetCode_00147 {

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param head 待排序链表头结点
     * @return 排序后链表的头结点
     */
    public ListNode insertionSortList(ListNode head) {
        // 新建一个哑结点 dummy，代表链表已排序部分的头部
        ListNode dummy = new ListNode(-1);
        // cur 指向待排序链表的头部
        ListNode cur = head;
        while (cur != null) {
            // 由于是单链表，从前往后遍历已排序部分，找到待排序结点的正确插入位置
            ListNode p = dummy;
            while (p.next != null && p.next.val <= cur.val) {
                p = p.next;
            }
            // 将 cur 插入到 p 之后
            ListNode next = cur.next;
            cur.next = p.next;
            p.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}
