package com.github.jerring.leetcode;

public class LeetCode_00137 {

//    public int singleNumber(int[] nums) {
//        int res = 0;
//        for (int i = 0; i < 32; i++) {
//            int t = 0;
//            for (int num : nums) {
//                t += (num >> i) & 1;
//            }
//            res |= (t % 3) << i;
//        }
//        return res;
//    }

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }

//    public int singleNumber(int[] nums) {
//        return singleNumber(nums, 3);
//    }
//
//    private int singleNumber(int[] nums, int k) {
//        int[] bits = new int[--k];
//        for (int num : nums) {
//            for (int i = 0; i < k; i++) {
//                int mask = -1;
//                for (int j = 0; j < k; j++) {
//                    if (i != j) {
//                        mask &= ~bits[j];
//                    }
//                }
//                bits[i] = (bits[i] ^ num) & mask;
//            }
//        }
//        return bits[0];
//    }
}
