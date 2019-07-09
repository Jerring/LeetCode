package com.github.jerring.leetcode;

public class LeetCode_00817 {

    public int numComponents(ListNode head, int[] G) {
        boolean[] vis = new boolean[10000];
        for (int g : G) {
            vis[g] = true;
        }
        int res = 0;
        for (; head != null; head = head.next) {
            if (vis[head.val] && (head.next == null || !vis[head.next.val])) {
                ++res;
            }
        }
        return res;
    }
}
