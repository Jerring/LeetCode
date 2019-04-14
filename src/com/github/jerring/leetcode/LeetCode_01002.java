package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_01002 {

    public List<String> commonChars(String[] A) {
        int[] cnt = new int[26];
        for (char c : A[0].toCharArray()) {
            ++cnt[c - 'a'];
        }
        for (int i = 1; i < A.length; ++i) {
            int[] count = new int[26];
            for (char c : A[i].toCharArray()) {
                ++count[c - 'a'];
            }
            for (int j = 0; j < 26; ++j) {
                cnt[j] = Math.min(cnt[j], count[j]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < cnt[i]; ++j) {
                res.add(String.valueOf((char) ('a' + i)));
            }
        }
        return res;
    }
}
