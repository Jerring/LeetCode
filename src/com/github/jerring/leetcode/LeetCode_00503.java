package com.github.jerring.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_00503 {

//    public int[] nextGreaterElements(int[] nums) {
//        int n = nums.length;
//        int len = (n << 1) - 1;
//        int[] res = new int[n];
//        Arrays.fill(res, -1);
//        Deque<Integer> stack = new ArrayDeque<>();
//        for (int i = 0; i < len; ++i) {
//            int t = i < n ? i : i - n;
//            while (!stack.isEmpty() && nums[t] > nums[stack.peek()]) {
//                res[stack.pop()] = nums[t];
//            }
//            stack.push(t);
//        }
//        return res;
//    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int len = (n << 1) - 1;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; ++i) {
            int x = nums[i < n ? i : i - n];
            while (!stack.isEmpty() && x > nums[stack.peek()]) {
                res[stack.pop()] = x;
            }
            // n 之前的才 push 进栈
            if (i < n) {
                stack.push(i);
            }
        }
        // 栈中剩余的元素就是不存在比当前元素大的下一个元素的元素的索引
        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        return res;
    }
}
