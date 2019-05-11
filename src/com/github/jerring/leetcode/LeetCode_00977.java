package com.github.jerring.leetcode;

public class LeetCode_00977 {

    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        int i = 0, j = n - 1, k = n - 1;
        while (i <= j) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                res[k--] = A[i] * A[i];
                ++i;
            } else {
                res[k--] = A[j] * A[j];
                --j;
            }
        }
        return res;
    }
}
