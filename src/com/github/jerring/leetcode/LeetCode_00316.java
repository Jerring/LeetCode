package com.github.jerring.leetcode;

public class LeetCode_00316 {

    public String removeDuplicateLetters(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            last[s.charAt(i) - 'a'] = i;
        }
        boolean[] vis = new boolean[26];
        char[] cs = new char[s.length()];
        int top = -1;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (!vis[c - 'a']) {
                while (top >= 0 && c < cs[top] && i < last[cs[top] - 'a']) {
                    vis[cs[top--] - 'a'] = false;
                }
                cs[++top] = c;
                vis[c - 'a'] = true;
            }
        }
        return String.valueOf(cs, 0, top + 1);
    }
}
