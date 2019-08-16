package com.github.jerring.leetcode;

public class LeetCode_00892 {

//    int[] dirs = {-1, 0, 1, 0, -1};
//
//    public int surfaceArea(int[][] grid) {
//        int n = grid.length;
//        int res = 0;
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (grid[i][j] > 0) {
//                    res += 2;                                               // 上下两面
//                    for (int k = 0; k < 4; ++k) {
//                        int x = i + dirs[k], y = j + dirs[k + 1];
//                        if (x >= 0 && x < n && y >= 0 && y < n) {
//                            res += Math.max(0, grid[i][j] - grid[x][y]);    // 比周围高的部分
//                        } else {
//                            res += grid[i][j];                              // 边缘部分
//                        }
//                    }
//                }
//            }
//        }
//        return res;
//    }

    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    res += 2 + grid[i][j] * 4;                              // 总的表面积
                    if (i > 0) {
                        res -= Math.min(grid[i][j], grid[i - 1][j]) * 2;    // 减去与前面重叠的面积
                    }
                    if (j > 0) {
                        res -= Math.min(grid[i][j], grid[i][j - 1]) * 2;    // 减去与左边重叠的面积
                    }
                }
            }
        }
        return res;
    }
}
