package com.github.jerring.leetcode;

public class LeetCode_00028 {

//    public int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
//    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int max = haystack.length() - needle.length();
        for (int i = 0; i <= max; ++i) {
            // 找到第一个相等的字符
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = i + 1;
                for (int k = 1; k < needle.length()
                        && haystack.charAt(j) == needle.charAt(k); ++k, ++j);
                // 找到整个字符串就返回
                if (j == i + needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
