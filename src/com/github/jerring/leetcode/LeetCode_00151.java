package com.github.jerring.leetcode;

public class LeetCode_00151 {

//    public String reverseWords(String s) {
//        while (s.contains("  ")) {
//            s = s.replaceAll("  ", " ");
//        }
//        String[] strings = s.trim().split(" ");
//        StringBuilder sb = new StringBuilder();
//        boolean first = true;
//        for (int i = strings.length - 1; i >= 0; --i) {
//            if (first) {
//                sb.append(strings[i]);
//                first = false;
//            } else {
//                sb.append(' ').append(strings[i]);
//            }
//        }
//        return sb.toString();
//    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int i = chars.length - 1;
        while (i >= 0) {
            while (i >= 0 && chars[i] == ' ') {
                --i;
            }
            if (i >= 0) {
                int j = i;
                while (i >= 0 && chars[i] != ' ') {
                    --i;
                }
                sb.append(chars, i + 1, j - i).append(' ');
                --i;
            }
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
