package com.github.jerring.leetcode;

public class LeetCode_00005 {

//    public String longestPalindrome(String s) {
//        StringBuilder sb = new StringBuilder("^");
//        for (char c : s.toCharArray()) {
//            sb.append('#').append(c);
//        }
//        sb.append("#$");
//        char[] cs = sb.toString().toCharArray();
//        int[] p = new int[cs.length];
//        int center = 0;
//        int right = 0;
//        int resc = 0;
//        for (int i = 1; cs[i] != '$'; ++i) {
//            p[i] = right > i ? Math.min(p[(center << 1) - i], right - i) : 1;
//            while (cs[i + p[i]] == cs[i - p[i]]) {
//                ++p[i];
//            }
//            if (i + p[i] > right) {
//                right = i + p[i];
//                center = i;
//            }
//            if (p[i] > p[resc]) {
//                resc = i;
//            }
//        }
//        sb = new StringBuilder();
//        int cnt = p[resc] - 1;
//        for (int i = resc - p[resc] + 2; cnt-- != 0; i += 2) {
//            sb.append(cs[i]);
//        }
//        return sb.toString();
//    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        char[] cs = s.toCharArray();
        int first = 0, last = -1;
        for (int i = 0; i < cs.length; ++i) {
            int[] border = getBorder(cs, i, i);     // 从 cs[i] 向外扩展
            if (border[1] - border[0] > last - first) {
                first = border[0];
                last = border[1];
            }
            border = getBorder(cs, i, i + 1);       // 从 cs[i]、cs[i + 1] 向外扩展
            if (border[1] - border[0] > last - first) {
                first = border[0];
                last = border[1];
            }
        }
        return String.valueOf(cs, first, last - first + 1);
    }

    private int[] getBorder(char[] cs, int l, int r) {
        while (l >= 0 && r < cs.length && cs[l] == cs[r]) {
            --l;
            ++r;
        }
        return new int[]{l + 1, r - 1};
    }
}
