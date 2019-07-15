package com.github.jerring.leetcode;

public class LeetCode_00148 {

//    /**
//     * 时间复杂度：O(nlogn)
//     * 空间复杂度：O(logn)
//     * @param head 待排序链表头结点
//     * @return 排序后链表的头结点
//     */
//    public ListNode sortList(ListNode head) {
//        quickSort(head, null);
//        return head;
//    }
//
//    /**
//     * 对区间 [head, end) 排序
//     * @param head 链表头结点
//     * @param end 链表尾结点（不包含）
//     */
//    private void quickSort(ListNode head, ListNode end) {
//        if (head != end) {
//            ListNode q = partition(head, end);
//            quickSort(head, q);
//            quickSort(q.next, end);
//        }
//    }
//
//    private ListNode partition(ListNode head, ListNode end) {
//        int x = head.val;
//        // p 代表小于 x 的最后一个结点
//        ListNode p = head;
//        ListNode q = head.next;
//        while (q != end) {
//            if (q.val < x) {
//                p = p.next;
//                swap(p, q);
//            }
//            q = q.next;
//        }
//        swap(head, p);
//        return p;
//    }
//
//    private void swap(ListNode p, ListNode q) {
//        int tmp = p.val;
//        p.val = q.val;
//        q.val = tmp;
//    }

    /**
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(logn)
     * 不用额外创建数组，空间复杂度降低了，链表排序的最佳方法
     *
     * @param head 待排序链表头结点
     * @return 排序后链表的头结点
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode a = sortList(head);
        ListNode b = sortList(fast);
        return mergeList(a, b);
    }

    private ListNode mergeList(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.val < b.val) {
            a.next = mergeList(a.next, b);
            return a;
        } else {
            b.next = mergeList(a, b.next);
            return b;
        }
    }
}
