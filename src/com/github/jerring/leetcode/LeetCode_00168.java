package com.github.jerring.leetcode;

public class LeetCode_00168 {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            --n;
            sb.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
