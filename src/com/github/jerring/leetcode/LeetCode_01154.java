package com.github.jerring.leetcode;

public class LeetCode_01154 {

    int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int dayOfYear(String date) {
        String[] strs = date.split("-");
        int y = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int d = Integer.parseInt(strs[2]);
        int res = 0;
        for (int i = 1; i < m; ++i) {
            res += days[i];
        }
        // 大于二月且是闰年额外加一
        if (m > 2 && (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0))) {
            ++res;
        }
        res += d;
        return res;
    }
}

