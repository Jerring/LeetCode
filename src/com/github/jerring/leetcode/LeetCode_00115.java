package com.github.jerring.leetcode;

public class LeetCode_00115 {

//    public int numDistinct(String s, String t) {
//        int m = s.length(), n = t.length();
//        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 0; i <= m; ++i) {
//            dp[i][0] = 1;
//        }
//        for (int i = 1; i <= m; ++i) {
//            for (int j = 1; j <= n; ++j) {
//                dp[i][j] = dp[i - 1][j];
//                if (s.charAt(i - 1) == t.charAt(j - 1)) {
//                    dp[i][j] += dp[i - 1][j - 1];
//                }
//            }
//        }
//        return dp[m][n];
//    }

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= m; ++i) {
            for (int j = n; j >= 1; --j) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[n];
    }
}
