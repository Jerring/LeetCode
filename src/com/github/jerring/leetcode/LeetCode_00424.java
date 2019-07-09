package com.github.jerring.leetcode;

public class LeetCode_00424 {

//    public int characterReplacement(String s, int k) {
//        char[] cs = s.toCharArray();
//        int res = 0;
//        for (char c = 'A'; c <= 'Z'; ++c) {
//            int cnt = k;
//            int l = 0, r = 0;
//            while (r < cs.length) {
//                if (cs[r++] != c) {
//                    --cnt;
//                    while (cnt < 0) {
//                        if (cs[l++] != c) {
//                            ++cnt;
//                        }
//                    }
//                }
//                res = Math.max(res, r - l);
//            }
//        }
//        return res;
//    }

    public int characterReplacement(String s, int k) {
        char[] cs = s.toCharArray();
        int[] map = new int[26];
        int res = 0;
        int max = 0;
        for (int l = 0, r = 0; r < cs.length; ) {
            max = Math.max(max, ++map[cs[r++] - 'A']);
            while (r - l - max > k) {
                --map[cs[l++] - 'A'];
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
