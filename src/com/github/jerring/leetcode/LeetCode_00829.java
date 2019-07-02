package com.github.jerring.leetcode;

public class LeetCode_00829 {

//    public int consecutiveNumbersSum(int N) {
//        int res = 0;
//        for (int b = 1; b * (b - 1) < 2 * N; ++b) {
//            if (2 * N % b == 0 && (2 * N / b - (b - 1)) % 2 == 0) {
//                ++res;
//            }
//        }
//        return res;
//    }

    public int consecutiveNumbersSum(int N) {
        int res = 0;
        for (int i = 1; i * (i - 1) / 2 < N; ++i) {
            if ((N - i * (i - 1) / 2) % i == 0) {
                ++res;
            }
        }
        return res;
    }
}
