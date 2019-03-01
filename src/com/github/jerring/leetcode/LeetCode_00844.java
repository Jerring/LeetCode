package com.github.jerring.leetcode;

public class LeetCode_00844 {

//    public boolean backspaceCompare(String S, String T) {
//        Stack<Character> s1 = new Stack<>();
//        Stack<Character> s2 = new Stack<>();
//        for (char c : S.toCharArray()) {
//            if (c != '#') {
//                s1.push(c);
//            } else if (!s1.isEmpty()) {
//                s1.pop();
//            }
//        }
//        for (char c : T.toCharArray()) {
//            if (c != '#') {
//                s2.push(c);
//            } else if (!s2.isEmpty()) {
//                s2.pop();
//            }
//        }
//        return s1.equals(s2);
//    }

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int skipS = 0;
        int skipT = 0;
        while (i >= 0 || j >= 0) {
            // 找到 S 下一个可能比较的字符
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    ++skipS;
                    --i;
                } else if (skipS > 0) {
                    --skipS;
                    --i;
                } else {
                    break;
                }
            }
            // 找到 T 下一个可能比较的字符
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    ++skipT;
                    --j;
                } else if (skipT > 0) {
                    --skipT;
                    --j;
                } else {
                    break;
                }
            }
            // 两个字符不相等
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }
            // 有字符和无字符
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            --i;
            --j;
        }
        return true;
    }
}
