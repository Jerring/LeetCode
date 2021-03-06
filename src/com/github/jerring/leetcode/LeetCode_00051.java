package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_00051 {

//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> res = new ArrayList<>();
//        char[][] cs = new char[n][n];
//        for (int i = 0; i < cs.length; ++i) {
//            Arrays.fill(cs[i], '.');
//        }
//        dfs(cs, 0, res);
//        return res;
//    }
//
//    private void dfs(char[][] cs, int r, List<List<String>> res) {
//        int n = cs.length;
//        if (r == n) {
//            List<String> list = new ArrayList<>(n);
//            for (int i = 0; i < n; ++i) {
//                list.add(new String(cs[i]));
//            }
//            res.add(list);
//            return;
//        }
//        for (int i = 0; i < n; ++i) {
//            if (isValid(cs, r, i)) {
//                cs[r][i] = 'Q';
//                dfs(cs, r + 1, res);
//                cs[r][i] = '.';
//            }
//        }
//    }
//
//    /**
//     * 检查是否合法（横竖斜不重复）
//     * @param cs 棋盘
//     * @param r  当前行
//     * @param c  当前列
//     * @return   合法为 true，否则为 false
//     */
//    private boolean isValid(char[][] cs, int r, int c) {
//        int j = c;
//        for (int i = r - 1; i >= 0; --i) {
//            if (cs[i][j] == 'Q') {
//                return false;
//            }
//        }
//        j = c - 1;
//        for (int i = r - 1; i >= 0 && j >= 0; --i) {
//            if (cs[i][j--] == 'Q') {
//                return false;
//            }
//        }
//        j = c + 1;
//        for (int i = r - 1; i >= 0 && j < cs.length; --i) {
//            if (cs[i][j++] == 'Q') {
//                return false;
//            }
//        }
//        return true;
//    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] cs = new char[n][n];
        boolean[] col = new boolean[n];             // 当前列
        boolean[] dia1 = new boolean[2 * n - 1];    // 对角线 1 横纵坐标相加为定值
        boolean[] dia2 = new boolean[2 * n - 1];    // 对角线 2 横纵坐标相减为定值
        for (int i = 0; i < cs.length; ++i) {
            Arrays.fill(cs[i], '.');
        }
        dfs(cs, 0, res, col, dia1, dia2);
        return res;
    }

    private void dfs(char[][] cs, int r, List<List<String>> res, boolean[] col, boolean[] dia1, boolean[] dia2) {
        int n = cs.length;
        if (r == n) {
            List<String> list = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                list.add(new String(cs[i]));
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (!col[i] && !dia1[r + i] && !dia2[r - i + n - 1]) {
                cs[r][i] = 'Q';
                col[i] = true;
                dia1[r + i] = true;
                dia2[r - i + n - 1] = true;
                dfs(cs, r + 1, res, col, dia1, dia2);
                cs[r][i] = '.';
                col[i] = false;
                dia1[r + i] = false;
                dia2[r - i + n - 1] = false;
            }
        }
    }
}
