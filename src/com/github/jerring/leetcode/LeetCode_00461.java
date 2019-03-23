package com.github.jerring.leetcode;

public class LeetCode_00461 {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
