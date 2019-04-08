package com.github.jerring.leetcode;

public class LeetCode_00709 {

    public String toLowerCase(String str) {
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; ++i) {
            cs[i] |= 0x20;
        }
        return new String(cs);
    }

//    public String toLowerCase(String str) {
//        return str.toLowerCase();
//    }
}
