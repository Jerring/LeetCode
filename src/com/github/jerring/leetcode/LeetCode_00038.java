package com.github.jerring.leetcode;

public class LeetCode_00038 {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = "1";
        while (--n != 0) {
            s = getNext(s);
        }
        return s;
    }

    private String getNext(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            ++cnt;
            if (i + 1 == length || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(cnt).append(s.charAt(i));
                cnt = 0;
            }
        }
        return sb.toString();
    }
}
