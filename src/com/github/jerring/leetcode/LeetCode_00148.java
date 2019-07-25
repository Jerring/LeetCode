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

//    /**
//     * 时间复杂度：O(nlogn)
//     * 空间复杂度：O(logn)
//     * 不用额外创建数组，空间复杂度降低了，链表排序的最佳方法
//     *
//     * @param head 待排序链表头结点
//     * @return 排序后链表的头结点
//     */
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode fast = head.next;
//        ListNode slow = head;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        fast = slow.next;
//        slow.next = null;
//        ListNode a = sortList(head);
//        ListNode b = sortList(fast);
//        return mergeList(a, b);
//    }
//
//    private ListNode mergeList(ListNode a, ListNode b) {
//        if (a == null) return b;
//        if (b == null) return a;
//        if (a.val < b.val) {
//            a.next = mergeList(a.next, b);
//            return a;
//        } else {
//            b.next = mergeList(a, b.next);
//            return b;
//        }
//    }


    /**
     * 自底向上的归并排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     *
     * @param head 待排序链表头结点
     * @return 排序后链表的头结点
     */
    public ListNode sortList(ListNode head) {
        int n = 0;
        for (ListNode p = head; p != null; p = p.next) {
            ++n;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int i = 1; i < n; i <<= 1) {
            ListNode cur = dummy;
            for (int j = 0; j + i < n; j += i << 1) {
                ListNode a = cur.next, b = cur.next;
                for (int k = 0; k < i; ++k) {
                    b = b.next;
                }
                int l = 0, r = 0;
                while (l < i && r < i && b != null) {
                    if (a.val < b.val) {
                        cur.next = a;
                        cur = a;
                        a = a.next;
                        ++l;
                    } else {
                        cur.next = b;
                        cur = b;
                        b = b.next;
                        ++r;
                    }
                }
                while (l < i) {
                    cur.next = a;
                    cur = a;
                    a = a.next;
                    ++l;
                }
                while (r < i && b != null) {
                    cur.next = b;
                    cur = b;
                    b = b.next;
                    ++r;
                }
                cur.next = b;
            }
        }
        return dummy.next;
    }
}
