package com.github.jerring.leetcode;

public class LeetCode_00925 {

    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }
        char[] cn = name.toCharArray();
        char[] ct = typed.toCharArray();
        int i = 0, j = 0;
        while (i < cn.length && j < ct.length) {
            if (cn[i] == ct[j]) {
                ++i;
            } else if (j == 0 || ct[j] != ct[j - 1]) {
                return false;
            }
            ++j;
        }
        if (i != cn.length) {
            return false;
        }
        // 判断是否存在多余不同的字符
        if (j > 0) {
            for (; j < ct.length; ++j) {
                if (ct[j] != ct[j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
