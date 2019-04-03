package com.github.jerring.leetcode;

public class LeetCode_00007 {

    public static int reverse(int x) {
        int r = 0;
        if (x > 0) {
            int m = Integer.MAX_VALUE / 10;
            while (x != 0) {
                int t = x % 10;
                x /= 10;
                if (r > m || (r == m && t > 7)) {
                    return 0;
                }
                r = r * 10 + t;
            }
        } else if (x < 0) {
            int m = Integer.MIN_VALUE / 10;
            while (x != 0) {
                int t = x % 10;
                x /= 10;
                if (r < m || (r == m && t < -8)) {
                    return 0;
                }
                r = r * 10 + t;
            }
        }
        return r;
    }

//    public static int reverse(int x) {
//        int r = 0;
//        while (x != 0) {
//            int t = x % 10;
//            int tmp = r * 10 + t;
//            if ((tmp - t) / 10 != r) {
//                return 0;
//            }
//            x /= 10;
//            r = tmp;
//        }
//        return r;
//    }
}
