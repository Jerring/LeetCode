package com.github.jerring.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_01137 {

//    static int[] f = new int[38];
//
//    static {
//        f[1] = f[2] = 1;
//        for (int i = 3; i < 38; ++i) {
//            f[i] = f[i - 1] + f[i - 2] + f[i - 3];
//        }
//    }
//
//    public int tribonacci(int n) {
//        return f[n];
//    }

    public int tribonacci(int n) {
        int[] f = new int[]{0, 1, 1, 2};
        for (int i = 4; i <= n; ++i) {
            f[i % 4] = f[(i - 1) % 4] + f[(i - 2) % 4] + f[(i - 3) % 4];
        }
        return f[n % 4];
    }
}

