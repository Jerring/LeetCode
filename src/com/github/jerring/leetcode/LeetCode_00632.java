package com.github.jerring.leetcode;

import java.util.List;
import java.util.PriorityQueue;

public class LeetCode_00632 {

    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        PriorityQueue<Data> queue = new PriorityQueue<>(k);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; ++i) {
            int val = nums.get(i).get(0);
            queue.offer(new Data(val, i));
            max = Math.max(max, val);
        }
        int[] res = new int[] {queue.peek().val, max};
        int[] index = new int[k];
        while (true) {
            Data data = queue.poll();
            if (max - data.val < res[1] - res[0]) {
                res[0] = data.val;
                res[1] = max;
            }
            int i = data.i;
            if (++index[i] == nums.get(i).size()) {
                break;
            }
            int val = nums.get(i).get(index[i]);
            queue.offer(new Data(val, i));
            max = Math.max(max, val);
        }
        return res;
    }

    class Data implements Comparable<Data> {
        int val;
        int i;

        public Data(int val, int i) {
            this.val = val;
            this.i = i;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(val, o.val);
        }
    }

//    public int[] smallestRange(List<List<Integer>> nums) {
//        int k = nums.size();
//        int[] index = new int[k];
//        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(nums.get(o1).get(index[o1]), nums.get(o2).get(index[o2]));
//            }
//        });
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < k; ++i) {
//            queue.offer(i);
//            max = Math.max(max, nums.get(i).get(0));
//        }
//        int[] res = new int[] {nums.get(queue.peek()).get(0), max};
//        while (true) {
//            int i = queue.poll();
//            List<Integer> list = nums.get(i);
//            if (max - list.get(index[i]) < res[1] - res[0]) {
//                res[0] = list.get(index[i]);
//                res[1] = max;
//            }
//            if (++index[i] == list.size()) {
//                break;
//            }
//            queue.offer(i);
//            max = Math.max(max, list.get(index[i]));
//        }
//        return res;
//    }
}