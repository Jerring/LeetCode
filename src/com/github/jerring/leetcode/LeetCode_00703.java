package com.github.jerring.leetcode;

import java.util.PriorityQueue;

public class LeetCode_00703 {

    class KthLargest {
        private final PriorityQueue<Integer> queue;
        private final int k;

        public KthLargest(int k, int[] nums) {
            queue = new PriorityQueue<>(k);
            this.k = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.offer(val);
            } else if (val > queue.peek()) {
                queue.poll();
                queue.offer(val);
            }
            return queue.peek();
        }
    }
}
