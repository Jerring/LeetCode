package com.github.jerring.leetcode;

import java.util.Arrays;

public class LeetCode_00387 {

//    public int firstUniqChar(String s) {
//        int[] cnt = new int[26];
//        for (int i = 0; i < s.length(); ++i) {
//            ++cnt[s.charAt(i) - 'a'];
//        }
//        for (int i = 0; i < s.length(); ++i) {
//            if (cnt[s.charAt(i) - 'a'] == 1) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public int firstUniqChar(String s) {
        int[] index = new int[26];
        Arrays.fill(index, -1);
        for (int i = 0; i < s.length(); ++i) {
            int j = s.charAt(i) - 'a';
            if (index[j] == -1) {
                index[j] = i;
            } else if (index[j] >= 0) {
                index[j] = -2;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; ++i) {
            if (index[i] >= 0) {
                res = Math.min(res, index[i]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
