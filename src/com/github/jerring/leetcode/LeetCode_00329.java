package com.github.jerring.leetcode;

public class LeetCode_00329 {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int res = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res = Math.max(res, dfs(matrix, i, j, cache));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int max = 1;
        int m = matrix.length, n = matrix[0].length;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[i][j] > matrix[x][y]) {
                max = Math.max(max, 1 + dfs(matrix, x, y, cache));
            }
        }
        cache[i][j] = max;
        return max;
    }
}
