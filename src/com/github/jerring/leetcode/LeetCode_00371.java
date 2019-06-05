package com.github.jerring.leetcode;

public class LeetCode_00371 {

    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

//    public int getSum(int a, int b) {
//        while (b != 0) {
//            int t1 = a ^ b;
//            int t2 = (a & b) << 1;
//            a = t1;
//            b = t2;
//        }
//        return a;
//    }
}
