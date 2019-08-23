package com.github.jerring.leetcode;

public class LeetCode_00072 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            f[i][0] = i;    // 只能删除
        }
        for (int i = 0; i <= n; ++i) {
            f[0][i] = i;    // 只能插入
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else {                    // 插入、删除、替换三者取最小值
                    f[i][j] = 1 + Math.min(f[i][j - 1], Math.min(f[i - 1][j], f[i - 1][j - 1]));
                }
            }
        }
        return f[m][n];
    }
}
