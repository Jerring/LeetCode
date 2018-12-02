package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }

//    private boolean match(String s, String p) {
//        int n = s.length();
//        for (int i = 0; i < n; ++i) {
//            for (int j = i + 1; j < n; ++j) {
//                if (s.charAt(i) == s.charAt(j) && p.charAt(i) != p.charAt(j)
//                        || s.charAt(i) != s.charAt(j) && p.charAt(i) == p.charAt(j)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    private boolean match(String s, String p) {
        // 两个数组记录字符出现位置，为 0 表示未出现过
        int[] index1 = new int[26];
        int[] index2 = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            int i1 = s.charAt(i) - 'a';
            int i2 = p.charAt(i) - 'a';
            // 不同表示不匹配
            if (index1[i1] != index2[i2]) {
                return false;
            }
            // 记录字符出现位置，注意取值为 [1, length]，因为 0 用来表示尚未出现过
            index1[i1] = index2[i2] = i + 1;
        }
        return true;
    }
}
