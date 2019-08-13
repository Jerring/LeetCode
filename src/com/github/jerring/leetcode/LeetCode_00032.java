package com.github.jerring.leetcode;

public class LeetCode_00032 {

//    public int longestValidParentheses(String s) {
//        int res = 0;
//        int[] f = new int[s.length()];
//        for (int i = 1; i < s.length(); ++i) {
//            if (s.charAt(i) == ')') {
//                if (s.charAt(i - 1) == '(') {
//                    f[i] = (i >= 2 ? f[i - 2] : 0) + 2;
//                } else if (i - f[i - 1] > 0 && s.charAt(i - f[i - 1] - 1) == '(') {
//                    f[i] = f[i - 1] + ((i - f[i - 1] >= 2 ? f[i - f[i - 1] - 2] : 0) + 2);
//                }
//                res = Math.max(res, f[i]);
//            }
//        }
//        return res;
//    }

    public int longestValidParentheses(String s) {
        int res = 0;
        for (int i = 0, left = 0, right = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                ++left;
            } else {
                ++right;
            }
            if (left == right) {
                res = Math.max(res, left << 1);
            } else if (left < right) {
                left = 0;
                right = 0;
            }
        }
        for (int i = s.length() - 1, left = 0, right = 0; i >= 0; --i) {
            if (s.charAt(i) == '(') {
                ++left;
            } else {
                ++right;
            }
            if (left == right) {
                res = Math.max(res, left << 1);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return res;
    }
}
