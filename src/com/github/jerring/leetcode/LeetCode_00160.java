package com.github.jerring.leetcode;

public class LeetCode_00160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        // 在第二次迭代时，两个指针要么相遇于相交结点，要么最后都变为 null
        while (pA != pB) {
            // 在第一次迭代结束时，将指针指向另一个链表的头部
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ListNode pA = headA;
//        ListNode pB = headB;
//        int lenA = 0;
//        int lenB = 0;
//        while (pA != null) {
//            ++lenA;
//            pA = pA.next;
//        }
//        while (pB != null) {
//            ++lenB;
//            pB = pB.next;
//        }
//        pA = headA;
//        pB = headB;
//        if (lenA > lenB) {
//            int diff = lenA - lenB;
//            while (diff-- != 0) {
//                pA = pA.next;
//            }
//        } else {
//            int diff = lenB - lenA;
//            while (diff-- != 0) {
//                pB = pB.next;
//            }
//        }
//        while (pA != pB) {
//            pA = pA.next;
//            pB = pB.next;
//        }
//        return pA;
//    }
}
