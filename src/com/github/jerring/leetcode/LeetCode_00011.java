package com.github.jerring.leetcode;

public class LeetCode_00011 {

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, area);
            if (height[i] < height[j]) {
                ++i;
            } else {
                --j;
            }
        }
        return res;
    }
}
