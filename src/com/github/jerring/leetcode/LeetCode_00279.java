package com.github.jerring.leetcode;

public class LeetCode_00279 {

//    public int numSquares(int n) {
//        Queue<int[]> queue = new ArrayDeque<>();
//        boolean[] vis = new boolean[n + 1];
//        queue.offer(new int[]{n, 0});
//        vis[n] = true;
//        while (!queue.isEmpty()) {
//            int[] cur = queue.poll();
//            for (int i = 1; ; ++i) {
//                int x = cur[0] - i * i;
//                if (x < 0) {
//                    break;
//                } else if (x == 0) {
//                    return cur[1] + 1;
//                }
//                if (!vis[x]) {
//                    queue.offer(new int[]{x, cur[1] + 1});
//                    vis[x] = true;
//                }
//            }
//        }
//        throw new IllegalArgumentException();
//    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // 最坏情况下就是本身，分解为 n 个 1
        for (int i = 1; i <= n; ++i) {
            dp[i] = i;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j * j <= i; ++j) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

//    // 运用拉格朗日四平方和定理和勒让德三平方和定理
//    public int numSquares(int n) {
//        int s = (int) Math.sqrt(n);
//        if (s * s == n) {
//            return 1;
//        }
//        while ((n & 3) == 0) {      // n % 4 == 0
//            n >>= 2;
//        }
//        if (((n - 7) & 7) == 0) {   // (n - 7) % 8 == 0
//            return 4;
//        }
//        for (int i = 1; i * i <= n; ++i) {
//            int j = (int) Math.sqrt(n - i * i);
//            if (i * i + j * j == n) {
//                return 2;
//            }
//        }
//        return 3;
//    }
}
