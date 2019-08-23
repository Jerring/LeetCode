package com.github.jerring.leetcode;

public class LeetCode_00097 {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int k = s3.length();
        if (m + n != k) {
            return false;
        }
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 1; i <= m; ++i) {
            f[i][0] = f[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= n; ++i) {
            f[0][i] = f[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    f[i][j] |= f[i - 1][j];
                }
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    f[i][j] |= f[i][j - 1];
                }
            }
        }
        return f[m][n];
    }
}
