package com.github.jerring.leetcode;

public class LeetCode_00459 {

    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}
