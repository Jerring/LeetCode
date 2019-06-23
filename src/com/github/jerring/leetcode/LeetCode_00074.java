package com.github.jerring.leetcode;

public class LeetCode_00074 {

//    public boolean searchMatrix(int[][] matrix, int target) {
//        int i = matrix.length - 1;
//        int j = 0;
//        while (i >= 0 && j < matrix[0].length) {
//            if (matrix[i][j] < target) {
//                ++j;
//            } else if (matrix[i][j] > target) {
//                --i;
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }

//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length == 0) {
//            return false;
//        }
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int lo = 0;
//        int hi = m * n - 1;
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            int val = matrix[mid / n][mid % n];
//            if (val < target) {
//                lo = mid + 1;
//            } else if (val > target) {
//                hi = mid - 1;
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l < r) {
            int mid = l + r >>> 1;
            if (matrix[mid / n][mid % n] >= target) r = mid;
            else l = mid + 1;
        }
        return matrix[r / n][r % n] == target;
    }
}
