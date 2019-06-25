package com.github.jerring.leetcode;

public class LeetCode_00441 {

    public int arrangeCoins(int n) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >>> 1;
            if (1L * mid * (mid + 1) / 2 <= n) l = mid;
            else r = mid - 1;
        }
        return r;
    }

//    public int arrangeCoins(int n) {
//        return (int) ((-1 + Math.sqrt(1 + 8L * n)) / 2);
//    }
}
