package com.github.jerring.leetcode;

public class LeetCode_00050 {

    public double myPow(double x, int n) {
        // int 型 −2^31 取负数会溢出，仍然是 −2^31，转换为 long 防溢出
        long y = n;
        // 将负幂转化为正幂计算
        if (y < 0) {
            x = 1 / x;
            y = -y;
        }
        double res = 1;
        while (y != 0) {
            if ((y & 1) == 1) {
                res *= x;
            }
            x *= x;
            y >>= 1;
        }
        return res;
    }
}
