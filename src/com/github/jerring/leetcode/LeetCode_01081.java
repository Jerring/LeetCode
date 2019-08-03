package com.github.jerring.leetcode;

public class LeetCode_01081 {

    public String smallestSubsequence(String text) {
        int[] cnt = new int[26];
        for (char c : text.toCharArray()) {
            ++cnt[c - 'a'];
        }
        boolean[] vis = new boolean[26];
        char[] cs = new char[text.length()];
        int top = -1;
        for (char c : text.toCharArray()) {
            --cnt[c - 'a'];
            if (!vis[c - 'a']) {
                while (top >= 0 && c < cs[top] && cnt[cs[top] - 'a'] > 0) {
                    vis[cs[top--] - 'a'] = false;
                }
                cs[++top] = c;
                vis[c - 'a'] = true;
            }
        }
        return String.valueOf(cs, 0, top + 1);
    }

//    public String smallestSubsequence(String text) {
//        int[] last = new int[26];
//        for (int i = 0; i < text.length(); ++i) {
//            last[text.charAt(i) - 'a'] = i;
//        }
//        char[] cs = new char[text.length()];
//        int top = -1;
//        int vis = 0;
//        for (int i = 0; i < text.length(); ++i) {
//            char c = text.charAt(i);
//            if ((vis & (1 << (c - 'a'))) == 0) {
//                while (top >= 0 && c < cs[top] && i < last[cs[top] - 'a']) {
//                    vis &= ~(1 << (cs[top--] - 'a'));
//                }
//                cs[++top] = c;
//                vis |= 1 << (c - 'a');
//            }
//        }
//        return String.valueOf(cs, 0, top + 1);
//    }
}
