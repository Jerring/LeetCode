package com.github.jerring.leetcode;

public class LeetCode_00279 {

//    public int numSquares(int n) {
//        List<Integer> squares = generateSquares(n);
//        Queue<Integer> queue = new LinkedList<>();
//        // 访问标志，用于剪枝
//        boolean[] vis = new boolean[n + 1];
//        vis[n] = true;
//        queue.offer(n);
//        int level = 0;
//        while (!queue.isEmpty()) {
//            ++level;
//            int size = queue.size();
//            while (size-- != 0) {
//                int cur = queue.poll();
//                for (int s : squares) {
//                    int next = cur - s;
//                    if (next < 0) {
//                        break;
//                    }
//                    if (next == 0) {
//                        return level;
//                    }
//                    // 剪枝（之前出现过现在出现不可能达到最小）
//                    if (vis[next]) {
//                        continue;
//                    }
//                    vis[next] = true;
//                    queue.offer(next);
//                }
//            }
//        }
//        return n;
//    }
//
//    /**
//     * 生成 n 以内的完全平方数
//     * @param n 输入
//     * @return  平方数的集合
//     */
//    private List<Integer> generateSquares(int n) {
//        List<Integer> squares = new ArrayList<>();
//        int square = 1;
//        int diff = 3;
//        while (square <= n) {
//            squares.add(square);
//            square += diff;
//            diff += 2;
//        }
//        return squares;
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
