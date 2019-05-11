package com.github.jerring.leetcode;

public class LeetCode_00845 {

    public int longestMountain(int[] A) {
        int n = A.length;
        if (n < 3) {
            return 0;
        }
        int res = 0;
        int i = 1;
        while (i < n) {
            if (A[i - 1] >= A[i]) {
                ++i;
                continue;
            }
            // 上升过程
            int s = i - 1;
            while (i < n && A[i - 1] < A[i]) {
                ++i;
            }
            if (i == n) {
                break;
            }
            if (A[i] == A[i - 1]) {
                continue;
            }
            // 下降过程
            while (i < n && A[i - 1] > A[i]) {
                ++i;
            }
            // 山脉为 [s, i - 1]
            res = Math.max(res, i - s);
        }
        return res;
    }
}
