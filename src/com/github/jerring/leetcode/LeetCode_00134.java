package com.github.jerring.leetcode;

public class LeetCode_00134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0, j; i < n; i += j + 1) {
            int s = 0;
            for (j = 0; j < n; ++j) {
                int k = (i + j) % n;
                s += gas[k] - cost[k];
                if (s < 0) {
                    break;
                }
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }

//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int total = 0;
//        int sum = 0;
//        int start = 0;
//        for (int i = 0; i < gas.length; ++i) {
//            total += gas[i] - cost[i];
//            sum += gas[i] - cost[i];
//            if (sum < 0) {
//                start = i + 1;
//                sum = 0;
//            }
//        }
//        return total >= 0 ? start : -1;
//    }
}
