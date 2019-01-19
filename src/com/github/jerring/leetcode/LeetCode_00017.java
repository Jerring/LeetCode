package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00017 {

//    public List<String> letterCombinations(String digits) {
//        List<String> res = new ArrayList<>();
//        if (digits == null || digits.length() == 0) {
//            return res;
//        }
//        String[] dict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        dfs(new StringBuilder(), digits, res, dict);
//        return res;
//    }
//
//    private void dfs(StringBuilder prefix, String digits, List<String> res, String[] dict) {
//        if (prefix.length() == digits.length()) {
//            res.add(prefix.toString());
//            return;
//        }
//        int index = digits.charAt(prefix.length()) - '2';
//        for (char c : dict[index].toCharArray()) {
//            // 添加
//            prefix.append(c);
//            dfs(prefix, digits, res, dict);
//            // 删除
//            prefix.deleteCharAt(prefix.length() - 1);
//        }
//    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        res.add("");
        String[] dict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (char c : digits.toCharArray()) {
            String s = dict[c - '2'];
            List<String> tmp = new ArrayList<>();
            for (String prefix : res) {
                for (char cur : s.toCharArray()) {
                    tmp.add(prefix + cur);
                }
            }
            res = tmp;
        }
        return res;
    }
}
