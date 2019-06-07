package com.github.jerring.leetcode;

public class LeetCode_00762 {

//    public int countPrimeSetBits(int L, int R) {
//        Set<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
//        int res = 0;
//        for (int i = L; i <= R; ++i) {
//            if (set.contains(Integer.bitCount(i))) {
//                ++res;
//            }
//        }
//        return res;
//    }

    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; ++i) {
            res += 665772 >> Integer.bitCount(i) & 1;   // 665772 = 0b1010 0010 1000 1010 1100
        }
        return res;
    }
}
