package com.github.jerring.leetcode;

public class LeetCode_01156 {

    public int maxRepOpt1(String text) {
        char[] cs = text.toCharArray();
        int[] cnt = new int[26];
        for (char c : cs) {
            ++cnt[c - 'a'];
        }
        int res = 0;
        for (char c = 'a'; c <= 'z'; ++c) {
            res = Math.max(res, process(c, cs, cnt));
        }
        return res;
    }

    private int process(char cur, char[] cs, int[] cnt) {
        int res = 0;
        for (int l = 0, r = 0, other = 0; r < cs.length; ) {
            if (cs[r++] != cur) {
                ++other;
                while (other > 1) {
                    if (cs[l++] != cur) {
                        --other;
                    }
                }
            }
            res = Math.max(res, r - l);
        }
        res = Math.min(res, cnt[cur - 'a']);
        return res;
    }

//    public int maxRepOpt1(String text) {
//        char[] cs = text.toCharArray();
//        int res = 0;
//        for (char c = 'a'; c <= 'z'; ++c) {
//            res = Math.max(res, process(c, cs));
//        }
//        return res;
//    }
//
//    private int process(char cur, char[] cs) {
//        int f = 0, g = 0;
//        int cnt = 0;
//        int res = 0;
//        for (char c : cs) {
//            if (c == cur) {
//                ++f;
//                ++g;
//                ++cnt;
//            } else {
//                g = f + 1;
//                f = 0;
//            }
//            res = Math.max(res, g);
//        }
//        res = Math.min(res, cnt);
//        return res;
//    }
}

