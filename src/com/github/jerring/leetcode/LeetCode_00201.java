package com.github.jerring.leetcode;

public class LeetCode_00201 {

//    public int rangeBitwiseAnd(int m, int n) {
//        int cnt = 0;
//        while (m != n) {
//            m >>= 1;
//            n >>= 1;
//            ++cnt;
//        }
//        return m << cnt;
//    }

    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n &= n - 1;
        }
        return n;
    }
}
