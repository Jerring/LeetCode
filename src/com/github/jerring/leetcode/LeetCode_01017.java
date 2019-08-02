package com.github.jerring.leetcode;

public class LeetCode_01017 {

//    public String baseNeg2(int N) {
//        StringBuilder sb = new StringBuilder();
//        while (N != 0) {
//            int r = N % -2;
//            N /= -2;
//            if (r < 0) {
//                r += 2;
//                ++N;
//            }
//            sb.append(r);
//        }
//        return sb.length() > 0 ? sb.reverse().toString() : "0";
//    }

    public String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            sb.append(N & 1);
            N = -(N >> 1);
        }
        return sb.reverse().toString();
    }
}

