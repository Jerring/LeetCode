package com.github.jerring.leetcode;

public class LeetCode_00367 {

//    public boolean isPerfectSquare(int num) {
//        int l = 1, r = num;
//        while (l < r) {
//            int mid = l + r >>> 1;
//            if ((long) mid * mid >= num) r = mid;
//            else l = mid + 1;
//        }
//        return r * r == num;
//    }

    public boolean isPerfectSquare(int num) {
        long r = num;
        while (r * r > num) {
            r = (r + num / r) / 2;
        }
        return r * r == num;
    }
}
