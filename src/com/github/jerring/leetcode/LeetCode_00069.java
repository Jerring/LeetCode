package com.github.jerring.leetcode;

public class LeetCode_00069 {

    public int mySqrt(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

//    public int mySqrt(int x) {
//        if (x <= 1) {
//            return x;
//        }
//        int lo = 0;
//        int hi = x;
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            int sqrt = x / mid;
//            if (mid < sqrt) {
//                lo = mid + 1;
//            } else if (mid > sqrt) {
//                hi = mid - 1;
//            } else {
//                return mid;
//            }
//        }
//        return hi;
//    }

//    public int mySqrt(int x) {
//        if (x <= 1) {
//            return x;
//        }
//        int lo = 1;
//        int hi = x;
//        while (true) {
//            int mid = lo + (hi - lo) / 2;
//            if (mid > x / mid) {
//                hi = mid - 1;
//            } else {
//                if (mid + 1 > x / (mid + 1)) {
//                    return mid;
//                }
//                lo = mid + 1;
//            }
//        }
//    }
}
