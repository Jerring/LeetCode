package com.github.jerring.leetcode;

public class LeetCode_01021 {

    public String removeOuterParentheses(String S) {
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        int left = 0;
        for (int i = 0; i < S.length(); ++i) {
            cnt += S.charAt(i) == '(' ? 1 : -1;
            if (cnt == 0) {
                res.append(S, left + 1, i);
                left = i + 1;
            }
        }
        return res.toString();
    }

//    public String removeOuterParentheses(String S) {
//        StringBuilder res = new StringBuilder();
//        int cnt = 0;
//        for (char c : S.toCharArray()) {
//            if (c == '(') {
//                if (++cnt > 1) {
//                    res.append('(');
//                }
//            } else {
//                if (--cnt > 0) {
//                    res.append(')');
//                }
//            }
//        }
//        return res.toString();
//    }
}

