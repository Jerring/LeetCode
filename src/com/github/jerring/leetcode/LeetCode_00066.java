package com.github.jerring.leetcode;

public class LeetCode_00066 {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            // 这一位小于 9 时，加上 1 之后就可以直接返回，因为不用进位
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            // 这一位为 9，加上 1 变为 10，进位后为 0
            digits[i] = 0;
        }
        // 数组的每个元素都为 9
        int[] ret = new int[n + 1];
        ret[0] = 1;
        return ret;
    }
}
