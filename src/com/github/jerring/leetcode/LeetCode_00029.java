package com.github.jerring.leetcode;

public class LeetCode_00029 {

    public int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }
        int x = -Math.abs(dividend), y = -Math.abs(divisor);
        int p = 1;
        while (y << 1 < 0 && y << 1 >= x) {
            y <<= 1;
            p <<= 1;
        }
        int res = 0;
        while (p >= 1) {
            if (x <= y) {
                x -= y;
                res += p;
            }
            y >>= 1;
            p >>= 1;
        }
        return dividend > 0 ^ divisor > 0 ? -res : res;
    }
}
