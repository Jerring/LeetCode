package com.github.jerring.leetcode;

public class LeetCode_00344 {

    public String reverseString(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0, j = cs.length - 1; i < j; ++i, --j) {
            char tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;
        }
        return new String(cs);
    }
}
