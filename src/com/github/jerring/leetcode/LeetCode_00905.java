package com.github.jerring.leetcode;

public class LeetCode_00905 {

    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            // 从前往后找奇数
            while (i < j && (A[i] & 1) == 0) {
                ++i;
            }
            // 从后往前找偶数
            while (i < j && (A[j] & 1) == 1) {
                --j;
            }
            // 交换这两个数
            if (i < j) {
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
        }
        return A;
    }
}
