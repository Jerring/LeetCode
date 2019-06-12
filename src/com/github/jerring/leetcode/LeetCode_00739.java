package com.github.jerring.leetcode;

import java.util.ArrayDeque;

public class LeetCode_00739 {

    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
