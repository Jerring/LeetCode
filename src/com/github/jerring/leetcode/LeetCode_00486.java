package com.github.jerring.leetcode;

public class LeetCode_00486 {

//    public boolean PredictTheWinner(int[] nums) {
//        int n = nums.length;
//        int[][] f = new int[n][n];
//        boolean flag = (n & 1) == 1;
//        if (flag) {
//            for (int i = 0; i < n; ++i) {
//                f[i][i] = nums[i];
//            }
//        }
//        for (int len = 2; len <= n; ++len) {
//            flag = !flag;
//            for (int i = 0; i + len - 1 < n; ++i) {
//                int j = i + len - 1;
//                if (flag) {
//                    f[i][j] = Math.max(f[i + 1][j] + nums[i], f[i][j - 1] + nums[j]);
//                } else {
//                    f[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
//                }
//            }
//        }
//        int sum = Arrays.stream(nums).sum();
//        return f[0][n - 1] >= sum - f[0][n - 1];
//    }

//    public boolean PredictTheWinner(int[] nums) {
//        int n = nums.length;
//        if ((n & 1) == 0) { // 长度为偶数必胜
//            return true;
//        }
//        int[][] f = new int[n][n];
//        boolean flag = (n & 1) == 1;
//        if (flag) {
//            for (int i = 0; i < n; ++i) {
//                f[i][i] = nums[i];
//            }
//        }
//        for (int len = 2; len <= n; ++len) {
//            flag = !flag;
//            for (int i = 0; i + len - 1 < n; ++i) {
//                int j = i + len - 1;
//                if (flag) {
//                    f[i][j] = Math.max(f[i + 1][j] + nums[i], f[i][j - 1] + nums[j]);
//                } else {
//                    f[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
//                }
//            }
//        }
//        int sum = Arrays.stream(nums).sum();
//        return f[0][n - 1] >= sum - f[0][n - 1];
//    }

//    public boolean PredictTheWinner(int[] nums) {
//        int n = nums.length;
//        if ((n & 1) == 0) {
//            return true;
//        }
//        int[][] f = new int[n][n];
//        for (int i = 0; i < n; ++i) {
//            f[i][i] = nums[i];
//        }
//        for (int len = 2; len <= n; ++len) {
//            for (int i = 0; i + len - 1 < n; ++i) {
//                int j = i + len - 1;
//                f[i][j] = Math.max(nums[i] - f[i + 1][j], nums[j] - f[i][j - 1]);
//            }
//        }
//        return f[0][n - 1] >= 0;
//    }

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        if ((n & 1) == 0) {
            return true;
        }
        int[] f = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            f[i] = nums[i];
            for (int j = i + 1; j < n; ++j) {
                f[j] = Math.max(nums[i] - f[j], nums[j] - f[j - 1]);
            }
        }
        return f[n - 1] >= 0;
    }
}
