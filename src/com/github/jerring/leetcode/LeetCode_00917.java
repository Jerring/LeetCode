package com.github.jerring.leetcode;

public class LeetCode_00917 {

    public String reverseOnlyLetters(String S) {
        char[] cs = S.toCharArray();
        for (int i = 0, j = cs.length - 1; i < j; ++i, --j) {
            while (i < j && !Character.isLetter(cs[i])) {
                ++i;
            }
            while (i < j && !Character.isLetter(cs[j])) {
                --j;
            }
            if (i >= j) {
                break;
            }
            swap(cs, i, j);
        }
        return String.valueOf(cs);
    }

    private void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}
