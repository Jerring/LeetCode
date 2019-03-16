package com.github.jerring.leetcode;

public class LeetCode_00221 {

//    public int maximalSquare(char[][] matrix) {
//        if (matrix == null || matrix.length == 0) {
//            return 0;
//        }
//        int m = matrix.length, n = matrix[0].length;
//        int[][] dp = new int[m][n];
//        int res = 0;
//        for(int i = 0; i < m; i++){
//            dp[i][0] = matrix[i][0] - '0';
//            res = Math.max(res, dp[i][0]);
//        }
//        for(int i = 0; i < n; i++){
//            dp[0][i] = matrix[0][i] - '0';
//            res = Math.max(res, dp[0][i]);
//        }
//        for (int i = 1; i < m; ++i) {
//            for (int j = 1; j < n; ++j) {
//                if (matrix[i][j] == '1') {
//                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
//                    res = Math.max(res, dp[i][j]);
//                }
//            }
//        }
//        return res * res;
//    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }

//    public int maximalSquare(char[][] matrix) {
//        if (matrix == null || matrix.length == 0) {
//            return 0;
//        }
//        int m = matrix.length, n = matrix[0].length;
//        int[] dp = new int[n + 1];
//        int pre = 0;
//        int res = 0;
//        for (int i = 1; i <= m; ++i) {
//            for (int j = 1; j <= n; ++j) {
//                int tmp = dp[j];
//                if (matrix[i - 1][j - 1] == '1') {
//                    dp[j] = 1 + Math.min(dp[j - 1], Math.min(pre, dp[j]));
//                    res = Math.max(res, dp[j]);
//                } else {
//                    dp[j] = 0;
//                }
//                pre = tmp;
//            }
//        }
//        return res * res;
//    }
}
