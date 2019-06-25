package com.github.jerring.leetcode;

public class LeetCode_00042 {

//    public int trap(int[] height) {
//        int res = 0;
//        Deque<Integer> stack = new ArrayDeque<>();
//        for (int i = 0; i < height.length; ++i) {
//            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
//                int cur = stack.pop();
//                if (!stack.isEmpty()) {
//                    int pre = stack.peek();
//                    res += (Math.min(height[pre], height[i]) - height[cur]) * (i - 1 - pre);
//                }
//            }
//            stack.push(i);
//        }
//        return res;
//    }

//    public int trap(int[] height) {
//        if (height == null || height.length < 3) {
//            return 0;
//        }
//        int n = height.length;
//        int[] leftMax = new int[n];
//        int[] rightMax = new int[n];
//        leftMax[0] = height[0];
//        for (int i = 1; i < n; ++i) {
//            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
//        }
//        rightMax[n - 1] = height[n - 1];
//        for (int i = n - 2; i >= 0; --i) {
//            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
//        }
//        int res = 0;
//        for (int i = 1; i < n - 1; ++i) {
//            res += Math.min(leftMax[i], rightMax[i]) - height[i];
//        }
//        return res;
//    }

    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int res = 0;
        int i = 0, j = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                if (height[i] > leftMax) {
                    leftMax = height[i];
                } else {
                    res += leftMax - height[i];
                }
                ++i;
            } else {
                if (height[j] > rightMax) {
                    rightMax = height[j];
                } else {
                    res += rightMax - height[j];
                }
                --j;
            }
        }
        return res;
    }
}
