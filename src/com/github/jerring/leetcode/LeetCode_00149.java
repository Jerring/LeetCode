package com.github.jerring.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_00149 {

    public int maxPoints(int[][] points) {
        int n = points.length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            // 同一直线上的点的个数（不包含坐标相同的点，坐标相同的点单独计算）
            Map<Slope, Integer> map = new HashMap<>();
            int duplicates = 0;
            for (int j = i + 1; j < n; ++j) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0 && y == 0) {
                    ++duplicates;
                } else {
                    int g = gcd(x, y);
                    Slope slope = new Slope(x / g, y / g);
                    map.put(slope, map.getOrDefault(slope, 1) + 1);
                }
            }
            // 用与定点重合的点的个数更新最大值
            res = Math.max(res, duplicates + 1);
            res = Math.max(res, map.values().stream().max(Integer::compareTo).orElse(0) + duplicates);
        }
        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    class Slope {
        int x, y;

        public Slope(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Slope slope = (Slope) o;

            if (x != slope.x) return false;
            return y == slope.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
