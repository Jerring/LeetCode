package com.github.jerring.leetcode;

public class LeetCode_00091 {

//    public int numDecodings(String s) {
//        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
//            return 0;
//        }
//        int pre2 = 1;
//        int pre1 = 1;
//        int res = 1;
//        char prec = s.charAt(0);
//        for (int i = 1; i < s.length(); ++i) {
//            char c = s.charAt(i);
//            if (c == '0') {
//                // 当 '0' 出现时，前面一个字符必须为 '1' 或 '2'，否则不是合法序列
//                if ((prec == '1' || prec == '2')) {
//                    res = pre2;
//                } else {
//                    return 0;
//                }
//            } else {
//                res = pre1;
//                if (prec == '1' || (prec == '2' && c <= '6')) {
//                    res += pre2;
//                }
//            }
//            pre2 = pre1;
//            pre1 = res;
//            prec = c;
//        }
//        return res;
//    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] = f[i - 1];
            }
            if (i >= 2) {
                int t = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                if (t >= 10 && t <= 26) {
                    f[i] += f[i - 2];
                }
            }
        }
        return f[n];
    }
}
