package com.github.jerring.leetcode;

public class LeetCode_00070 {

//    public int climbStairs(int n) {
//        if (n <= 2) {
//            return n;
//        }
//        int a = 1, b = 2;
//        int res = 0;
//        for (int i = 3; i <= n; ++i) {
//            res = a + b;
//            a = b;
//            b = res;
//        }
//        return res;
//    }

    /**
     * f[0] = 0
     * f[1] = 1
     * f[2] = 1
     * f[3] = 2
     * f[n] = f[n - 1] + f[n - 2]
     * Fibonacci 公式：f[n] = 1 / √5 * {(1 + √5) / 2] ^ n - [(1 - √5) / 2] ^ n}
     * @param n 下标 n
     * @return  f[n]
     */
    public int climbStairs(int n) {
        ++n;    // 调整以运用公式
        double sqrt5 = Math.sqrt(5);
        return (int) ((Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n)) / sqrt5);
    }
}
