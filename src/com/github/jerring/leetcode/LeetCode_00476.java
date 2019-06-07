package com.github.jerring.leetcode;

public class LeetCode_00476 {

//    public int findComplement(int num) {
//        int res = 0;
//        int t = 0;
//        while (num != 0) {
//            res |= ((num & 1) == 1 ? 0 : 1) << t++;
//            num >>= 1;
//        }
//        return res;
//    }

    public int findComplement(int num) {
//        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
        return num ^ ((Integer.highestOneBit(num) << 1) - 1);
    }
}
