package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00986 {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int m = A.length, n = B.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (A[i][1] < B[j][0]) {
                ++i;
            } else if (B[j][1] < A[i][0]) {
                ++j;
            } else {
                res.add(new int[] {Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])});
                if (A[i][1] < B[j][1]) {
                    ++i;
                } else {
                    ++j;
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
