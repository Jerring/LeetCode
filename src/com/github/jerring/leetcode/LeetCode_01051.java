package com.github.jerring.leetcode;

import java.util.Arrays;

public class LeetCode_01051 {

//    public int heightChecker(int[] heights) {
//        int[] copy = Arrays.copyOf(heights, heights.length);
//        Arrays.sort(copy);
//        int res = 0;
//        for (int i = 0; i < heights.length; ++i) {
//            if (heights[i] != copy[i]) {
//                ++res;
//            }
//        }
//        return res;
//    }

    public int heightChecker(int[] heights) {
        int[] cnt = new int[101];
        for (int height : heights) {
            ++cnt[height];
        }
        int res = 0;
        for (int i = 0, j = 0; i < cnt.length; i++) {
            while (cnt[i]-- > 0) {
                if (i != heights[j++]) {
                    ++res;
                }
            }
        }
        return res;
    }
}
