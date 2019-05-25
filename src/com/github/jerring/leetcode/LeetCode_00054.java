package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00054 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (top <= bottom && left <= right) {
            processEdge(matrix, top++, bottom--, left++, right--, res);
        }
        return res;
    }

    private void processEdge(int[][] matrix, int top, int bottom, int left, int right, List<Integer> res) {
        if (top == bottom) {
            for (int i = left; i <= right; ++i) {
                res.add(matrix[top][i]);
            }
            return;
        }
        if (left == right) {
            for (int i = top; i <= bottom; ++i) {
                res.add(matrix[i][right]);
            }
            return;
        }
        int i = top, j = left;
        while (j != right) {
            res.add(matrix[i][j++]);
        }
        while (i != bottom) {
            res.add(matrix[i++][j]);
        }
        while (j != left) {
            res.add(matrix[i][j--]);
        }
        while (i != top) {
            res.add(matrix[i--][j]);
        }
    }
}
