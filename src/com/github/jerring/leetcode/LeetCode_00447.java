package com.github.jerring.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_00447 {

//    public int numberOfBoomerangs(int[][] points) {
//        int res = 0;
//        for (int i = 0; i < points.length; ++i) {
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int j = 0; j < points.length; ++j) {
//                if (i != j) {
//                    int dis = getDistance(points[i], points[j]);
//                    map.put(dis, map.getOrDefault(dis, 0) + 1);
//                }
//            }
//            for (int num : map.values()) {
//                res += num * (num - 1);
//            }
//        }
//        return res;
//    }

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; ++i) {
            for (int j = 0; j < points.length; ++j) {
                if (i != j) {
                    int dis = getDistance(points[i], points[j]);
                    map.put(dis, map.getOrDefault(dis, 0) + 1);
                }
            }
            for (int num : map.values()) {
                res += num * (num - 1);
            }
            map.clear();
        }
        return res;
    }

//    public int numberOfBoomerangs(int[][] points) {
//        int res = 0;
//        for (int i = 0; i < points.length; ++i) {
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int j = 0; j < points.length; ++j) {
//                if (i != j) {
//                    int dis = getDistance(points[i], points[j]);
//                    Integer v = map.get(dis);
//                    if (v == null) {
//                        map.put(dis, 1);
//                    } else {
//                        map.put(dis, v + 1);
//                        res += v << 1;
//                    }
//                }
//            }
//        }
//        return res;
//    }

//    public int numberOfBoomerangs(int[][] points) {
//        int res = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < points.length; ++i) {
//            for (int j = 0; j < points.length; ++j) {
//                if (i != j) {
//                    int dis = getDistance(points[i], points[j]);
//                    Integer v = map.get(dis);
//                    if (v == null) {
//                        map.put(dis, 1);
//                    } else {
//                        map.put(dis, v + 1);
//                        res += v << 1;
//                    }
//                }
//            }
//            map.clear();
//        }
//        return res;
//    }

    private int getDistance(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return x * x + y * y;
    }
}
