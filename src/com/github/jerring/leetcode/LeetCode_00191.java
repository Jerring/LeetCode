package com.github.jerring.leetcode;

public class LeetCode_00191 {

//    public int hammingWeight(int n) {
//        int res = 0;
//        for (int i = 0; i < 32; ++i) {
//            if ((n & 1) == 1) {
//                ++res;
//            }
//            n >>>= 1;
//        }
//        return res;
//    }

//    public int hammingWeight(int n) {
//        int res = 0;
//        while (n != 0) {
//            ++res;
//            n &= n - 1;
//        }
//        return res;
//    }

//    public int hammingWeight(int n) {
//        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
//        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
//        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
//        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
//        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
//        return n;
//    }

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
