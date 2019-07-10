package com.github.jerring.leetcode;

public class LeetCode_01004 {

    public int longestOnes(int[] A, int K) {
        int res = 0;
        for (int l = 0, r = 0; r < A.length; ) {
            if (A[r++] == 0) {
                --K;
                while (K < 0) {
                    if (A[l++] == 0) {
                        ++K;
                    }
                }
            }
            res = Math.max(res, r - l);
        }
        return res;
    }

//    public int longestOnes(int[] A, int K) {
//        int l = 0, r = 0;
//        while (r < A.length) {
//            if (A[r++] == 0) --K;
//            if (K < 0 && A[l++] == 0) ++K;
//        }
//        return r - l;
//    }
}
