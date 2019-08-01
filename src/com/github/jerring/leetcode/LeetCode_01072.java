package com.github.jerring.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_01072 {

//    public int maxEqualRowsAfterFlips(int[][] matrix) {
//        Map<String, Integer> map = new HashMap<>();
//        for (int[] row : matrix) {
//            if (row[0] == 1) {
//                for (int i = 0; i < row.length; ++i) {
//                    row[i] ^= 1;
//                }
//            }
//            StringBuilder sb = new StringBuilder();
//            for (int x : row) {
//                sb.append(x);
//            }
//            String s = sb.toString();
//            map.put(s, map.getOrDefault(s, 0) + 1);
//        }
//        return map.values().stream().max(Integer::compareTo).get();
//    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            if (row[0] == 1) {
                for (int i = 0; i < row.length; ++i) {
                    row[i] ^= 1;
                }
            }
            int k = Arrays.hashCode(row);
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        return map.values().stream().max(Integer::compareTo).get();
    }
}
