package com.github.jerring.leetcode;

public class LeetCode_01147 {

    public int longestDecomposition(String text) {
        char[] cs = text.toCharArray();
        int res = 0;
        for (int i = 0, j = cs.length - 1; i <= j; ) {
            boolean flag = true;
            for (int k = 1; i + k - 1 < j - k + 1; ++k) {
                if (check(cs, i, j - k + 1, k)) {
                    res += 2;
                    i += k;
                    j -= k;
                    flag = false;
                    break;
                }
            }
            // 中间最后一个回文串
            if (flag) {
                ++res;
                break;
            }
        }
        return res;
    }

    private boolean check(char[] cs, int i, int j, int k) {
        while (k-- > 0) {
            if (cs[i++] != cs[j++]) {
                return false;
            }
        }
        return true;
    }

//    public int longestDecomposition(String text) {
//        if (text.isEmpty()) {
//            return 0;
//        }
//        for (int i = 0, n = text.length(); i < n / 2; ++i) {
//            if (text.substring(0, i + 1).equals(text.substring(n - 1 - i))) {
//                return 2 + longestDecomposition(text.substring(i + 1, n - 1 - i));
//            }
//        }
//        return 1;
//    }
}

