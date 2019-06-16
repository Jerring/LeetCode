package com.github.jerring.leetcode;

public class LeetCode_00006 {

    public String convert(String s, int numRows) {
        if (s.isEmpty() || numRows == 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; ++i) {
            sbs[i] = new StringBuilder();
        }
        boolean down = false;
        int index = 0;
        for (char c : s.toCharArray()) {
            sbs[index].append(c);
            if (index == 0 || index == numRows - 1) {
                down = !down;
            }
            index += down ? 1 : -1;
        }
        for (int i = 1; i < numRows; ++i) {
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }
}
