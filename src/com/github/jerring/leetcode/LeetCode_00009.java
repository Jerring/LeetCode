package com.github.jerring.leetcode;

public class LeetCode_00009 {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int r = 0;
        while (r < x) {
            r = 10 * r + x % 10;
            x /= 10;
        }
        return x == r || x == r / 10;
    }
}
