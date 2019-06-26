package com.github.jerring.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_00084 {

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        // 为了方便结算，提前 push 一个下标 -1
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int cur = stack.pop();
                res = Math.max(res, heights[cur] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        // 结算栈中剩余的元素
        while (stack.peek() != -1) {
            int cur = stack.pop();
            res = Math.max(res, heights[cur] * (heights.length - stack.peek() - 1));
        }
        return res;
    }
}
