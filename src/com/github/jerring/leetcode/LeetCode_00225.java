package com.github.jerring.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_00225 {

//    // push: O(1), pop: O(n), peek: O(n)
//    class MyStack {
//
//        private Queue<Integer> queue;
//
//        /** Initialize your data structure here. */
//        public MyStack() {
//            queue = new LinkedList<>();
//        }
//
//        /** Push element x onto stack. */
//        public void push(int x) {
//            queue.offer(x);
//        }
//
//        /** Removes the element on top of the stack and returns that element. */
//        public int pop() {
//            int size = queue.size();
//            while (size-- > 1) {
//                queue.offer(queue.poll());
//            }
//            return queue.poll();
//        }
//
//        /** Get the top element. */
//        public int top() {
//            int size = queue.size();
//            while (size-- > 1) {
//                queue.offer(queue.poll());
//            }
//            int x = queue.poll();
//            queue.offer(x);
//            return x;
//        }
//
//        /** Returns whether the stack is empty. */
//        public boolean empty() {
//            return queue.isEmpty();
//        }
//    }

    // push: O(n), pop: O(1), peek: O(1)
    class MyStack {

        private Queue<Integer> in;
        private Queue<Integer> out;

        /** Initialize your data structure here. */
        public MyStack() {
            in = new LinkedList<>();
            out = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            in.offer(x);
            while (!out.isEmpty()) {
                in.offer(out.poll());
            }
            // 交换两者的角色（in 为空，out 按元素的逆序排列）
            Queue tmp = in;
            in = out;
            out = tmp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return out.poll();
        }

        /** Get the top element. */
        public int top() {
            return out.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return out.isEmpty();
        }
    }
}
