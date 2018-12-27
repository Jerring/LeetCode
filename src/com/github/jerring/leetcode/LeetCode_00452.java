package com.github.jerring.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_00452 {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        // 使用 lambda 表达式创建 Comparator 会使程序运行时间变长，可以改为匿名内部类的形式
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return Integer.compare(o1[1], o2[1]);
//            }
//        });
        int res = 1;
        int pre = points[0][1];
        for (int i = 1; i < points.length; ++i) {
            if (points[i][0] > pre) {
                ++res;
                pre = points[i][1];
            }
        }
        return res;
    }
}
