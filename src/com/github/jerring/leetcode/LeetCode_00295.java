package com.github.jerring.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode_00295 {

    class MedianFinder {

        private Queue<Integer> small;
        private Queue<Integer> large;

        /** initialize your data structure here. */
        public MedianFinder() {
            small = new PriorityQueue<>(Comparator.reverseOrder());
            large = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (small.isEmpty() || num <= small.peek()) {
                small.offer(num);
                if (small.size() > large.size() + 1) {
                    large.offer(small.poll());
                }
            } else {
                large.offer(num);
                if (large.size() > small.size()) {
                    small.offer(large.poll());
                }
            }
        }

        public double findMedian() {
            if (small.size() == large.size()) {
                return ((double) small.peek() + large.peek()) / 2;
            } else {
                return small.peek();
            }
        }
    }
}
