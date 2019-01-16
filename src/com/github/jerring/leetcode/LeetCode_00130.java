package com.github.jerring.leetcode;

public class LeetCode_00130 {

    public void solve(char[][] board) {
        // 为空检查
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        // 把四个边界上的 'O' 的连通区域全部变为 '1'
        for (int i = 0; i < m; ++i) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 0; i < n; ++i) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        // 最后为 'O' 说明不与边界区域 'O' 连通，为 '1' 说明为边界 '0' 连通区域，恢复原状即可
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '1';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
