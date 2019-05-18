package com.github.jerring.leetcode;

public class LeetCode_00036 {

//    public boolean isValidSudoku(char[][] board) {
//        boolean[][] row = new boolean[9][9];  // 代表每一行
//        boolean[][] col = new boolean[9][9];  // 代表每一列
//        boolean[][] block = new boolean[9][9];  // 代表每个 3x3 宫格
//        for (int i = 0; i < 9; ++i) {
//            for (int j = 0; j < 9; ++j) {
//                if (board[i][j] != '.') {
//                    int t = board[i][j] - '1';
//                    int k = i / 3 * 3 + j / 3;
//                    if (row[i][t] || col[j][t] || block[k][t]) {
//                        return false;
//                    }
//                    row[i][t] = true;
//                    col[j][t] = true;
//                    block[k][t] = true;
//                }
//            }
//        }
//        return true;
//    }

    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];  // 代表每一行
        int[] col = new int[9];  // 代表每一列
        int[] block = new int[9];  // 代表每个 3x3 宫格
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    // 映射到对应的二进制位
                    int t = 1 << (board[i][j] - '1');
                    int k = i / 3 * 3 + j / 3;
                    if ((row[i] & t) != 0 || (col[j] & t) != 0 || (block[k] & t) != 0) {
                        return false;
                    }
                    row[i] |= t;
                    col[j] |= t;
                    block[k] |= t;
                }
            }
        }
        return true;
    }
}
