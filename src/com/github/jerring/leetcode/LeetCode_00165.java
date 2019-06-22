package com.github.jerring.leetcode;

public class LeetCode_00165 {

//    public int compareVersion(String version1, String version2) {
//        String[] str1 = version1.split("\\.");
//        String[] str2 = version2.split("\\.");
//        int i = 0, j = 0;
//        while (i < str1.length || j < str2.length) {
//            int a = i < str1.length ? Integer.parseInt(str1[i++]) : 0;
//            int b = j < str2.length ? Integer.parseInt(str2[j++]) : 0;
//            if (a > b) return 1;
//            if (a < b) return -1;
//        }
//        return 0;
//    }

    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        while (i < version1.length() || j < version2.length()) {
            int a = 0, b = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                a = a * 10 + version1.charAt(i++) - '0';
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                b = b * 10 + version2.charAt(j++) - '0';
            }
            if (a > b) return 1;
            if (a < b) return -1;
            ++i;
            ++j;
        }
        return 0;
    }
}
