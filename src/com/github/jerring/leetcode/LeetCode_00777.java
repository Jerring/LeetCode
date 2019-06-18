package com.github.jerring.leetcode;

public class LeetCode_00777 {

    public boolean canTransform(String start, String end) {
        // 长度不等肯定不能转换
        if (start.length() != end.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (true) {
            // 跳过非空字符
            while (i < start.length() && start.charAt(i) == 'X') {
                ++i;
            }
            while (j < end.length() && end.charAt(j) == 'X') {
                ++j;
            }
            // 同时到达末尾返回 true
            if (i == start.length() && j == start.length()) {
                return true;
            }
            // 只有一个到达末尾返回 false
            if (i == start.length() || j == start.length() || start.charAt(i) != end.charAt(j)) {
                return false;
            }
            // 要满足“L 只能往左走，R 只能往右走”的条件
            if (start.charAt(i) == 'L' && i < j || start.charAt(i) == 'R'  && i > j) {
                return false;
            }
            ++i;
            ++j;
        }
    }
}
