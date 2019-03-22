package com.github.jerring.leetcode;

public class LeetCode_00342 {

    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
//        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) == num;
//        return num > 0 && (num & (num - 1)) == 0 && (num & 0xaaaaaaaa) == 0;
//        return num > 0 && (num & (num - 1)) == 0 && (num | 0x55555555) == 0x55555555;
    }
}
