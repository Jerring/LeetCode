package com.github.jerring.leetcode;

public class LeetCode_00058 {

    public int lengthOfLastWord(String s) {
        int res = 0;
        int i = s.length() - 1;
        // 跳过最后的空格
        for (; i >= 0 && s.charAt(i) == ' '; --i);
        // 统计最后一个单词的长度
        for (; i >= 0 && s.charAt(i) != ' '; --i) {
            ++res;
        }
        return res;
    }
}
