package com.github.jerring.leetcode;

public class LeetCode_00023 {

//    // 时间复杂度为 O(nlogk)
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) {
//            return null;
//        }
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return Integer.compare(o1.val, o2.val);
//            }
//        });
//        for (ListNode node : lists) {
//            if (node != null) {
//                queue.offer(node);
//            }
//        }
//        ListNode dummy = new ListNode(-1);
//        ListNode cur = dummy;
//        while (!queue.isEmpty()) {
//            cur.next = queue.poll();
//            cur = cur.next;
//            if (cur.next != null) {
//                queue.offer(cur.next);
//            }
//        }
//        return dummy.next;
//    }

    // 时间复杂度为 O(nlogk)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeRangeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeRangeLists(ListNode[] lists, int lo, int hi) {
        if (lo == hi) {
            return lists[lo];
        }
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = mergeRangeLists(lists, lo, mid);
        ListNode l2 = mergeRangeLists(lists, mid + 1, hi);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode node =  dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 != null) {
            node.next = l1;
        }
        if (l2 != null) {
            node.next = l2;
        }
        return dummy.next;
    }
}
