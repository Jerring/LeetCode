package com.github.jerring.leetcode;

public class LeetCode_00278 {

    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + r >>> 1;
            if (isBadVersion(mid)) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    // 题目已定义，无须实现，此处为了避免编译错误而添加
    private boolean isBadVersion(int mid) {
        return true;
    }
}
