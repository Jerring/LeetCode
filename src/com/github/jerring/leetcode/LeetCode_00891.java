package com.github.jerring.leetcode;

import java.util.Arrays;

public class LeetCode_00891 {

    public int sumSubseqWidths(int[] A) {
        final int MOD = (int) (1e9 + 7);
        Arrays.sort(A);
        int n = A.length;
        long res = 0;
        long p = 1;
        for (int i = 0; i < n; ++i) {
            res = (res + (A[i] - A[n - 1 - i]) * p) % MOD;
            p = (p << 1) % MOD;
        }
        return (int) ((res + MOD) % MOD);
    }

//    public int sumSubseqWidths(int[] A) {
//        final int MOD = (int) (1e9 + 7);
//        Arrays.sort(A);
//        int n = A.length;
//        long res = 0;
//        long p = 1;
//        long sum = 0;
//        for (int x : A) {
//            res = (res + x * (p - 1) - sum) % MOD;
//            p = (p << 1) % MOD;
//            sum = (sum * 2 + x) % MOD;
//        }
//        return (int) ((res + MOD) % MOD);
//    }
}
