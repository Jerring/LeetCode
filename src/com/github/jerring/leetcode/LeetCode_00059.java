package com.github.jerring.leetcode;

public class LeetCode_00059 {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;
        while (top <= bottom && left <= right) {
            num = fillEdge(res, top++, bottom--, left++, right--, num);
        }
        return res;
    }

    private int fillEdge(int[][] res, int top, int bottom, int left, int right, int num) {
        if (top == bottom) {
            for (int i = left; i <= right; ++i) {
                res[top][i] = num++;
            }
        } else if (left == right) {
            for (int i = top; i <= bottom; ++i) {
                res[i][right] = num++;
            }
        } else {
            int i = top, j = left;
            while (j != right) {
                res[i][j++] = num++;
            }
            while (i != bottom) {
                res[i++][j] = num++;
            }
            while (j != left) {
                res[i][j--] = num++;
            }
            while (i != top) {
                res[i--][j] = num++;
            }
        }
        return num;
    }
}
