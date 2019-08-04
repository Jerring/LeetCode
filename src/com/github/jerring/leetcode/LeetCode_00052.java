package com.github.jerring.leetcode;

public class LeetCode_00052 {

    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];             // 当前列
        boolean[] dia1 = new boolean[2 * n - 1];    // 对角线 1 横纵坐标相加为定值
        boolean[] dia2 = new boolean[2 * n - 1];    // 对角线 2 横纵坐标相减为定值
        return dfs(n, 0, col, dia1, dia2);
    }

    private int dfs(int n, int r, boolean[] col, boolean[] dia1, boolean[] dia2) {
        if (r == n) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (!col[i] && !dia1[r + i] && !dia2[r - i + n - 1]) {
                col[i] = true;
                dia1[r + i] = true;
                dia2[r - i + n - 1] = true;
                res += dfs(n, r + 1, col, dia1, dia2);
                col[i] = false;
                dia1[r + i] = false;
                dia2[r - i + n - 1] = false;
            }
        }
        return res;
    }
}
