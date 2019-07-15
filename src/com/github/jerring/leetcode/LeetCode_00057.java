package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode_00057 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        List<int[]> res = new ArrayList<>();
        boolean added = false;
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                res.add(interval);
            } else if (interval[0] > newInterval[1]) {
                if (!added) {
                    added = true;
                    res.add(newInterval);
                }
                res.add(interval);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        if (!added) {
            res.add(newInterval);
        }
        return res.toArray(new int[0][]);
    }
}
