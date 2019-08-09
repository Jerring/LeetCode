package com.github.jerring.leetcode;

public class LeetCode_00509 {

    public int fib(int N) {
        if (N < 2) {
            return N;
        }
        int a = 0, b = 1;
        int res = 0;
        for (int i = 2; i <= N; ++i) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}

