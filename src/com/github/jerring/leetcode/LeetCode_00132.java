package com.github.jerring.leetcode;

public class LeetCode_00132 {

//    public int minCut(String s) {
//        char[] cs = s.toCharArray();
//        int n = cs.length;
//        // c[i][j] 表示 cs[i, j] 是否为回文串
//        boolean[][] c = new boolean[n][n];
//        for (int i = 0; i < n; ++i) {
//            for (int j = i; j >= 0; --j) {
//                c[j][i] = cs[j] == cs[i] && (j + 1 > i - 1 || c[j + 1][i - 1]);
//            }
//        }
//        // f[i] 表示将 s[0, i] 分割成回文串的最少分割次数
//        int[] f = new int[n];
//        for (int i = 0; i < n; ++i) {
//            f[i] = i;
//        }
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j <= i; ++j) {
//                if (c[j][i]) {
//                    f[i] = Math.min(f[i], j > 0 ? f[j - 1] + 1 : 0);
//                }
//            }
//        }
//        return f[n - 1];
//    }

    public int minCut(String s) {
        int n = s.length();
        // f[i] 表示将 s[0, i] 分割成回文串的最少分割次数
        int[] f = new int[n];
        for (int i = 0; i < n; ++i) {
            f[i] = i;
        }
        for (int i = 0; i < n; ++i) {
            expand(s, i, i, f);
            expand(s, i, i + 1, f);
        }
        return f[n - 1];
    }

    private void expand(String s, int i, int j, int[] f) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            f[j] = Math.min(f[j], i > 0 ? f[i - 1] + 1 : 0);
            --i;
            ++j;
        }
    }
}
