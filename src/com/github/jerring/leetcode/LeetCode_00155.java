package com.github.jerring.leetcode;

import java.util.Stack;

public class LeetCode_00155 {

//    class MinStack {
//        private Stack<Integer> numStack;
//        private Stack<Integer> minStack;
//
//        /** initialize your data structure here. */
//        public MinStack() {
//            numStack = new Stack<>();
//            minStack = new Stack<>();
//        }
//
//        public void push(int x) {
//            numStack.push(x);
//            if (minStack.isEmpty() || x <= minStack.peek()) {
//                minStack.push(x);
//            }
//        }
//
//        public void pop() {
//            int x = numStack.pop();
//            if (x == minStack.peek()) {
//                minStack.pop();
//            }
//        }
//
//        public int top() {
//            return numStack.peek();
//        }
//
//        public int getMin() {
//            return minStack.peek();
//        }
//    }

    class MinStack {
        private Stack<Integer> stack;
        private int min;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if (min == stack.pop()) {
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
