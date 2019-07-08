package com.github.jerring.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode_01019 {

//    public int[] nextLargerNodes(ListNode head) {
//        int n = getLength(head);
//        int[] res = new int[n];
//        int i = 0;
//        Deque<int[]> stack = new ArrayDeque<>();
//        for (; head != null; head = head.next, ++i) {
//            while (!stack.isEmpty() && head.val > stack.peek()[0]) {
//                res[stack.pop()[1]] = head.val;
//            }
//            stack.push(new int[]{head.val, i});
//        }
//        return res;
//    }
//
//    private int getLength(ListNode head) {
//        int res = 0;
//        while (head != null) {
//            ++res;
//            head = head.next;
//        }
//        return res;
//    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < list.size(); ++i) {
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                res[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}

