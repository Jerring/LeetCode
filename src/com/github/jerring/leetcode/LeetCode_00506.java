package com.github.jerring.leetcode;

import java.util.Arrays;

public class LeetCode_00506 {

//    public String[] findRelativeRanks(int[] nums) {
//        int n = nums.length;
//        int[][] arr = new int[n][2];
//        for (int i = 0; i < n; ++i) {
//            arr[i][0] = nums[i];
//            arr[i][1] = i;
//        }
//        Arrays.sort(arr, (o1, o2) -> Integer.compare(o2[0], o1[0]));
//        String[] res = new String[n];
//        int rank = 0;
//        for (int[] x : arr) {
//            ++rank;
//            if (rank == 1) {
//                res[x[1]] = "Gold Medal";
//            } else if (rank == 2) {
//                res[x[1]] = "Silver Medal";
//            } else if (rank == 3) {
//                res[x[1]] = "Bronze Medal";
//            } else {
//                res[x[1]] = String.valueOf(rank);
//            }
//        }
//        return res;
//    }

    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; ++i) {
            index[i] = i;
        }
        Arrays.sort(index, (o1, o2) -> Integer.compare(nums[o2], nums[o1]));
        String[] res = new String[n];
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                res[index[i]] = "Gold Medal";
            } else if (i == 1) {
                res[index[i]] = "Silver Medal";
            } else if (i == 2) {
                res[index[i]] = "Bronze Medal";
            } else {
                res[index[i]] = String.valueOf(i + 1);
            }
        }
        return res;
    }
}
