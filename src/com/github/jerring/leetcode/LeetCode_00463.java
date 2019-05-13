package com.github.jerring.leetcode;

public class LeetCode_00463 {

//    public int islandPerimeter(int[][] grid) {
//        int n = grid.length, m = grid[0].length;
//        int res = 0;
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < m; ++j) {
//                if (grid[i][j] == 1) {
//                    if (i - 1 < 0 || grid[i - 1][j] == 0) ++res;
//                    if (j - 1 < 0 || grid[i][j - 1] == 0) ++res;
//                    if (i + 1 >= n || grid[i + 1][j] == 0) ++res;
//                    if (j + 1 >= m || grid[i][j + 1] == 0) ++res;
//                }
//            }
//        }
//        return res;
//    }

    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (i > 0 && grid[i - 1][j] == 1) res -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) res -= 2;
                }
            }
        }
        return res;
    }
}
