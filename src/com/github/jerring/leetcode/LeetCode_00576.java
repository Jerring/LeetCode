package com.github.jerring.leetcode;

import java.util.Arrays;

public class LeetCode_00576 {

    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    final int MOD = (int) (1e9 + 7);

    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] dp = new int[m][n][N + 1];
        // 初始化为一个不可能的值
        for (int[][] am : dp) {
            for (int[] an : am) {
                Arrays.fill(an, -1);
            }
        }
        return dfs(m, n, N, i, j, dp);
    }

    private int dfs(int m, int n, int k, int i, int j, int[][][] dp) {
        if (i < 0 || i == m || j < 0 || j == n) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        int res = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            res += dfs(m, n, k - 1, x, y, dp);
            res %= MOD;
        }
        dp[i][j][k] = res;
        return res;
    }

//    public int findPaths(int m, int n, int N, int i, int j) {
//        final int MOD = (int) (1e9 + 7);
//        final int[] dirs = new int[]{-1, 0, 1, 0, -1};
//        int[][] f = new int[m][n];
//        f[i][j] = 1;
//        int res = 0;
//        for (int step = 0; step < N; ++step) {
//            int[][] temp = new int[m][n];
//            for (int x = 0; x < m; ++x) {
//                for (int y = 0; y < n; ++y) {
//                    for (int k = 0; k < 4; ++k) {
//                        int tx = x + dirs[k], ty = y + dirs[k + 1];
//                        if (tx >= 0 && tx < m && ty >= 0 && ty < n) {
//                            temp[tx][ty] += f[x][y];
//                            temp[tx][ty] %= MOD;
//                        } else {
//                            res += f[x][y];
//                            res %= MOD;
//                        }
//                    }
//                }
//            }
//            f = temp;
//        }
//        return res;
//    }
}
