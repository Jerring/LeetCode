package com.github.jerring.leetcode;

public class LeetCode_00028 {

//    public int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
//    }

//    public int strStr(String haystack, String needle) {
//        if (needle.length() == 0) {
//            return 0;
//        }
//        int max = haystack.length() - needle.length();
//        for (int i = 0; i <= max; ++i) {
//            // 找到第一个相等的字符
//            if (haystack.charAt(i) == needle.charAt(0)) {
//                int j = i + 1;
//                for (int k = 1; k < needle.length()
//                        && haystack.charAt(j) == needle.charAt(k); ++k, ++j);
//                // 找到整个字符串就返回
//                if (j == i + needle.length()) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }

    // KMP
    public int strStr(String haystack, String needle) {
        int[] next = getNextArray(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else if (next[j] != -1) {
                j = next[j];
            } else {
                ++i;
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    private int[] getNextArray(String s) {
        if (s.length() <= 1) {
            return new int[] { -1 };
        }
        int[] next = new int[s.length()];
        next[0] = -1;
        next[1] = 0;
        int len = 0;
        int i = 2;
        while (i < s.length()) {
            if (s.charAt(i - 1) == s.charAt(len)) {
                next[i++] = ++len;
            } else if (len > 0) {
                len = next[len];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
