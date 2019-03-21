package com.github.jerring.leetcode;

public class LeetCode_00231 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
//        return n > 0 && (n & -n) == n;
    }
}
