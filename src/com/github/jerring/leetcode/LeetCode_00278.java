package com.github.jerring.leetcode;

public class LeetCode_00278 {

    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // 题目已定义，无须实现，此处为了避免语法错误而添加
    private boolean isBadVersion(int mid) {
        return true;
    }
}
