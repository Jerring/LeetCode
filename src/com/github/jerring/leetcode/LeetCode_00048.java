package com.github.jerring.leetcode;

public class LeetCode_00048 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                swap(matrix, i, j, j, i);
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0, k = n - 1; j < k; ++j, --k) {
                swap(matrix, i, j, i, k);
            }
        }
    }

    private void swap(int[][] matrix, int i, int j, int x, int y) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = tmp;
    }
}
